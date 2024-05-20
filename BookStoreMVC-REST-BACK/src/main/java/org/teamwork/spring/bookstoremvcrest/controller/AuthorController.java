package org.teamwork.spring.bookstoremvcrest.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.AuthorDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.AuthorServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Validator validator;

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public List<AuthorDTO> findAll(@RequestParam(value = "filter", required = false) String filter) throws NotFoundException {
        if (filter == null)
            return authorService.findAll();
        return authorService.filter(filter);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        AuthorDTO authorDTO = authorService.findByKey(id);
        if (authorDTO == null) {
            throw new NotFoundException();
        }
        return authorDTO;
    }

    @GetMapping(value = "/image/{image}")
    public ResponseEntity<Resource> getImage(@PathVariable("image") String imageName, @Value("${images.authors.path}") String authorsImagesFolder) throws IOException {
        String fullPath = authorsImagesFolder + imageName;
        Path path = Paths.get(fullPath);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(new FileSystemResource(path));
    }

//    @PostMapping("")
////    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String save(@Valid @RequestBody AuthorDTO authorDTO) throws UnexpectedIdException {
//        if (authorDTO.getId() != null) {
//            throw new UnexpectedIdException();
//        }
//        authorService.save(authorDTO);
//        return "Save success!";
//    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO save(/*@RequestBody(required = false) MultipartFile photo*/@RequestParam(name="photo", required = false) MultipartFile photo, @RequestParam(name = "author") String json) throws IOException, UnexpectedIdException {
//        AuthorDTO author = objectMapper.readValue(json, AuthorDTO.class);
//        System.out.println("Photo: " + photo);
//        System.out.println("JSON: " + json);
//        System.out.println("Author: " + author);

        AuthorDTO authorDTO = objectMapper.readValue(json, AuthorDTO.class);

        if (authorDTO.getId() != null && authorDTO.getId() != 0) {
            throw new UnexpectedIdException();
        }

        Set<ConstraintViolation<AuthorDTO>> violations = validator.validate(authorDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (authorDTO.getId() != null && authorDTO.getId() != 0) {
            throw new UnexpectedIdException();
        }

        if (photo != null) {
            return authorService.saveWithPhoto(authorDTO, photo);
        } else {
            return authorService.save(authorDTO);
        }
    }

//    @PatchMapping("/{id}")
////    @PreAuthorize("hasRole('ADMIN')")
//    @ResponseStatus(HttpStatus.OK)
//    public String update(@Valid @RequestBody AuthorDTO authorDTO, @PathVariable Integer id) {
//        authorService.update(id, authorDTO);
//        return "Success!";
//    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO update(@RequestParam(value = "photo", required = false) MultipartFile photo, @RequestParam(name = "author") String json, @PathVariable(name = "id") Integer id) throws IOException, NotFoundException {
//        System.out.println("Photo: " + photo);
//        System.out.println("JSON: " + json);
//        System.out.println("Id: " + id);

        AuthorDTO authorDTO = objectMapper.readValue(json, AuthorDTO.class);

        if (photo != null) {
            return authorService.updateWithPhoto(id, authorDTO, photo);
        }
        return authorService.update(id, authorDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) throws NotFoundException {
        authorService.delete(id);
//        return "Deleted successful!";
    }
}