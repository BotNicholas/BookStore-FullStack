package org.teamwork.spring.bookstoremvcrest.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapper;
import org.teamwork.spring.bookstoremvcrest.model.Author;
import org.teamwork.spring.bookstoremvcrest.model.dto.AuthorDTO;
import org.teamwork.spring.bookstoremvcrest.repository.AuthorRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;
import org.teamwork.spring.bookstoremvcrest.utils.FilesHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements DefaultService<AuthorDTO, Author, Integer> {
    @Value("${images.authors.path}")
    private String authorsImagesFolder;
    @Value("${images.books.path}")
    private String booksImagesFolder;
    private final AuthorRepository authorRepository;
    private final AbstractMapper mapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AbstractMapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> mapper.toDTO(author, AuthorDTO.class)).collect(Collectors.toList());
    }

    public List<AuthorDTO> filter(String filter) throws NotFoundException {
        List<Author> authors = Collections.EMPTY_LIST;

//        if (filter.matches("author-\\d+")) {
//            authors = List.of(authorRepository.findById(Integer.parseInt(filter.substring(7))).orElseThrow(()-> new NotFoundException("Such Author does not exist!")));
//        } else {
        if (false) {
            //...
        } else {
            authors = authorRepository.findAll();
        }

        return authors.stream().map((author -> mapper.toDTO(author, AuthorDTO.class))).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO findByKey(Integer key) {
        return mapper.toDTO(authorRepository.findById(key).orElse(null), AuthorDTO.class);
    }

    @Override
    public AuthorDTO save(AuthorDTO obj) {
        Author author = authorRepository.save(mapper.toEntity(obj, Author.class));
        return mapper.toDTO(author, AuthorDTO.class);
    }

    public AuthorDTO saveWithPhoto(AuthorDTO obj, MultipartFile photo) throws IOException {
        String savedFileName = FilesHandler.saveFile(authorsImagesFolder+photo.getOriginalFilename(), photo.getBytes());
        if (!photo.getOriginalFilename().equals(savedFileName)) {
            obj.setImage(savedFileName);
        }
        Author author = authorRepository.save(mapper.toEntity(obj, Author.class));

        return mapper.toDTO(author, AuthorDTO.class);
    }

    @Override
    public AuthorDTO update(Integer key, AuthorDTO authorDTO) {
        Author author = mapper.toEntity(authorDTO, Author.class);
        author.setId(key);
        authorRepository.save(author);
        return mapper.toDTO(author, AuthorDTO.class);
    }

    public AuthorDTO updateWithPhoto(Integer id, AuthorDTO authorDTO, MultipartFile photo) throws NotFoundException, IOException {
//        Author author = mapper.toEntity(authorDTO, Author.class);
//        author.setId(id);

        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Such author does not exist"));
        String savedFileName = FilesHandler.updateFile(authorsImagesFolder + author.getImage(), authorsImagesFolder + photo.getOriginalFilename(), photo.getBytes());

        if (!photo.getOriginalFilename().equals(savedFileName)) {
            authorDTO.setImage(savedFileName);
        }

        author = mapper.toEntity(authorDTO, Author.class);
        author.setId(id);
        author = authorRepository.save(author);

        return mapper.toDTO(author, AuthorDTO.class);
    }


//    private void deleteFile(String path){
//        File oldFile = new File(path);
//        if (oldFile.exists() && !oldFile.getName().equals("Placeholder.png")) {
//            oldFile.delete();
//        }
//    }


    //If you need to save children just remove relations on both sides
//    @Override
//    @Transactional
//    public void delete(Integer key) throws NotFoundException {
//        Author author = authorRepository.findById(key).orElseThrow(()->new NotFoundException("Such author does not exist!"));
//        Author author1 = authorRepository.findById(1).orElseThrow(()->new NotFoundException("Such author does not exist!"));
//
//        author.getBooks().forEach(book -> book.setAuthor(author1));
//        author.setBooks(null);
//
//        FilesHandler.deleteFile(authorsImagesFolder+author.getImage());
//        authorRepository.deleteById(key);
//    }
    @Override
    public void delete(Integer key) throws NotFoundException {
        Author author = authorRepository.findById(key).orElseThrow(()->new NotFoundException("Such author does not exist!"));

        author.getBooks().forEach(book -> FilesHandler.deleteFile(booksImagesFolder + book.getImage()));

        FilesHandler.deleteFile(authorsImagesFolder+author.getImage());
        authorRepository.deleteById(key);
    }
}
