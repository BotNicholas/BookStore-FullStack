package org.teamwork.spring.bookstoremvcrest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.BookServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Validator validator;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findAll(@RequestParam(value = "filter", required = false) String filter) {
//        System.out.println("CONTROLLER: " + filter);
        if (filter == null)
            return bookService.findAll();
        return bookService.filter(filter);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        BookDTO bookDTO = bookService.findByKey(id);
        if (bookDTO == null) {
            throw new NotFoundException();
        }
        return bookDTO;
    }

//    @GetMapping(value = "/image/{image}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<byte[]> getImage(@PathVariable("image") String imageName, @Value("${images.books.path}") String booksImagesFolder) throws IOException {
//        String fullPath = booksImagesFolder + imageName;
//        Path path = Paths.get(fullPath);
//
//        return ResponseEntity.ok(Files.readAllBytes(path));
//
////        return ResponseEntity.ok()
//////                             .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
////                             .body(new FileSystemResource(path));
//    }

//    THIS SOLUTION WORKS ONLY FOR JPEG FILES. WE CAN USE RESPONSE STATUS FOR MORE DYNAMIC SOLUTION
//    @GetMapping(value = "/image/{image}")
//    public ResponseEntity<byte[]> getImage(@PathVariable("image") String imageName, @Value("${images.books.path}") String booksImagesFolder) throws IOException {
//        String fullPath = booksImagesFolder + imageName;
//        Path path = Paths.get(fullPath);
//
//        return ResponseEntity.ok()
//                             .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
//                             .body(Files.readAllBytes(path));
//    }


//    OR WE CAN USE Resources INTERFACE FOR MORE FAST AND EASY SOLUTIONS
    @GetMapping(value = "/image/{image}")
    public ResponseEntity<Resource> getImage(@PathVariable("image") String imageName, @Value("${images.books.path}") String booksImagesFolder) throws IOException {
        String fullPath = booksImagesFolder + imageName;
        Path path = Paths.get(fullPath);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(new FileSystemResource(path));
    }



//    @PostMapping("")
////    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String save(@Valid @RequestBody BookDTO bookDTO) throws UnexpectedIdException {
//        if (bookDTO.getId() != null) {
//            throw new UnexpectedIdException();
//        }
//        bookService.save(bookDTO);
//        return "Success!";
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BookDTO save(@RequestParam(name = "photo", required = false)MultipartFile photo, @RequestParam(name = "book") String json) throws IOException, UnexpectedIdException {
        BookDTO bookDTO = objectMapper.readValue(json, BookDTO.class);

        if (bookDTO.getId() != null && bookDTO.getId() != 0) {
            throw new UnexpectedIdException();
        }

        Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }


        if (photo != null) {
            return this.bookService.saveWithPhoto(bookDTO, photo);
        }
        return this.bookService.save(bookDTO);
    }

//    @PatchMapping("/{id}")
////    @PreAuthorize("hasRole('ADMIN')")
//    @ResponseStatus(HttpStatus.OK)
//    public String update(@Valid @RequestBody BookDTO bookDTO, @PathVariable("id") Integer id) {
//        bookService.update(id, bookDTO);
//        return "Success!";
//    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@RequestParam(name = "photo", required = false) MultipartFile photo, @RequestParam(name = "book") String json, @PathVariable(name = "id") Integer id) throws IOException, NotFoundException {
        //Needed because Jackson works only with @RequestBody. @RequestParam is used to extract simple objects
        BookDTO bookDTO = objectMapper.readValue(json, BookDTO.class);

        if (photo != null) {
            return this.bookService.updateWithPhoto(id, bookDTO, photo);
        }
        return this.bookService.update(id, bookDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) throws NotFoundException {
        bookService.delete(id);
//        return "Deleted successful!";
    }
}