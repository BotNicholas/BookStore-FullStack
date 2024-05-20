package org.teamwork.spring.bookstoremvcrest.security.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreRegistrationUserDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
import org.teamwork.spring.bookstoremvcrest.security.services.BookStoreUserServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Validator validator;
    @Autowired
    private ObjectMapper objectMapper;
    
    private final BookStoreUserServiceImpl service;
//    private final PasswordEncoder encoder;

    public UsersController(BookStoreUserServiceImpl service/*, PasswordEncoder encoder*/) {
        this.service = service;
//        this.encoder = encoder;
    }

    @GetMapping
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<BookStoreUserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookStoreUserDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        BookStoreUserDTO userDTO = service.findByKey(id);
        if (userDTO == null) {
            throw new NotFoundException("Such user was not found!");
        }
        return userDTO;
    }

    @GetMapping(value = "/image/{image}")
    public ResponseEntity<Resource> getImage(@PathVariable("image") String imageName, @Value("${images.users.path}") String usersImagesFolder) throws IOException {
        String fullPath = usersImagesFolder + imageName;
        Path path = Paths.get(fullPath);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(new FileSystemResource(path));
    }

    //todo: add save and update logic as for authors or books. You also have validator, so you can validate the objects
    //todo: add validation to authors and books controllers (places, where images are present)
    //todo: check if Validation is present everywhere, where you've changed the logic

    //USEFULL: https://www.geeksforgeeks.org/hibernate-validator-with-example/
//    @PostMapping("")
////    @PreAuthorize("hasRole('ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public BookStoreUserDTO save(@Valid @RequestBody BookStoreUserDTO bookStoreUserDTO) throws UnexpectedIdException {
//        if (bookStoreUserDTO.getId() != null && bookStoreUserDTO.getId() != 0) {
//            throw new UnexpectedIdException("Id is unexpected for User");
//        }
////        bookStoreUserDTO.setPassword(encoder.encode(bookStoreUserDTO.getPassword()));
//        return service.save(bookStoreUserDTO);
//    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public BookStoreUserDTO save(@RequestParam(name = "photo", required = false) MultipartFile photo, @RequestParam(name = "user") String json) throws UnexpectedIdException, IOException, ConstraintViolationException {
        BookStoreUserDTO bookStoreUserDTO = objectMapper.readValue(json, BookStoreUserDTO.class);

        if (bookStoreUserDTO.getId() != null && bookStoreUserDTO.getId() != 0) {
            throw new UnexpectedIdException("Id is unexpected for User");
        }

        Set<ConstraintViolation<BookStoreUserDTO>> violations = validator.validate(bookStoreUserDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (photo != null){
            return service.saveWithPhoto(bookStoreUserDTO, photo);
        }
//        bookStoreUserDTO.setPassword(encoder.encode(bookStoreUserDTO.getPassword()));
        return service.save(bookStoreUserDTO);
    }

//    @PatchMapping("/{id}")
////    @PreAuthorize("hasRole('ADMIN')")
//    @ResponseStatus(HttpStatus.OK)
//    public BookStoreUserDTO update(@PathVariable("id") Integer id, @Valid @RequestBody BookStoreUserDTO bookStoreUserDTO) {
//        return service.update(id, bookStoreUserDTO);
//    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookStoreUserDTO update(@RequestParam(name = "photo", required = false) MultipartFile photo, @RequestParam("user") String json, @PathVariable("id") Integer id) throws IOException, UnexpectedIdException, NotFoundException {
        BookStoreUserDTO bookStoreUserDTO = objectMapper.readValue(json, BookStoreUserDTO.class);

        if (bookStoreUserDTO.getId() != null && bookStoreUserDTO.getId() != 0) {
            throw new UnexpectedIdException("Id is unexpected for User!");
        }

        Set<ConstraintViolation<BookStoreUserDTO>> violations = validator.validate(bookStoreUserDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (photo != null) {
            return service.updateWithPhoto(id, bookStoreUserDTO, photo);
        }
        return service.update(id, bookStoreUserDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@Valid @RequestBody BookStoreRegistrationUserDTO userDTO) throws UnexpectedIdException {
        if (userDTO.getId() != null) {
            throw new UnexpectedIdException("Id is unexpected here!");
        }
//        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        service.register(userDTO);
        return "Success!";
    }

//    @GetMapping("/me")
//    @ResponseStatus(HttpStatus.OK)
//    public BookStoreUserDTO getPersonalData(Authentication authentication) {
//        return service.findByUsername(authentication.getName());
//    }

//    @PatchMapping("/me")
//    @ResponseStatus(HttpStatus.OK)
//    public String updatePersonalData(Authentication authentication, @Valid @RequestBody BookStoreUserDTO bookStoreUserDTO) throws UnexpectedIdException {
//        if (bookStoreUserDTO.getId() != null) {
//            throw new UnexpectedIdException("Id is unexpected here!");
//        }
//        service.update(authentication.getName(), bookStoreUserDTO);
//        authentication.setAuthenticated(false); //reset authentication
//        return "Success!";
//    }
}
