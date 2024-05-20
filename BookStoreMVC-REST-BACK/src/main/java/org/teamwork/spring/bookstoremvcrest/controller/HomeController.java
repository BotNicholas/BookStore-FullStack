package org.teamwork.spring.bookstoremvcrest.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.teamwork.spring.bookstoremvcrest.utils.FilesHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class HomeController {
    @GetMapping
    public String welcome() {
        return "welcome";
    }

//    @GetMapping(value = "show")
//    public ResponseEntity<Resource> getImage() throws IOException {
//        FileSystemResource resource = FilesHandler.readPhoto("src/main/resources/static/images/users/admin.jpg");
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(Paths.get(resource.getPath())))).body(resource);
//    }
}