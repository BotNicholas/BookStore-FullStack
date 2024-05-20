package org.teamwork.spring.bookstoremvcrest.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapper;
import org.teamwork.spring.bookstoremvcrest.model.Book;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookDTO;
import org.teamwork.spring.bookstoremvcrest.repository.BookRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;
import org.teamwork.spring.bookstoremvcrest.utils.FilesHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements DefaultService<BookDTO, Book, Integer> {
    private final BookRepository bookRepository;
    private final AbstractMapper mapper;
    @Value("${images.books.path}")
    private String booksImagesFolderPath;

    public BookServiceImpl(BookRepository bookRepository, AbstractMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> mapper.toDTO(book, BookDTO.class)).collect(Collectors.toList());
    }

    public List<BookDTO> filter(String filter) {
        List<Book> books = Collections.EMPTY_LIST;

//        System.out.println("SERVICE: " + filter);

        if (filter.matches("category-\\d+")){
//            System.out.println(filter.substring(9));
            books = bookRepository.findAllByCategory_Code(Integer.parseInt(filter.substring(9)));
        } else if(filter.matches("author-\\d+")) {
            books = bookRepository.findAllByAuthor_Id(Integer.parseInt(filter.substring(7)));
        } else {
                books = bookRepository.findAll();

        }

        return books.stream().map(book -> mapper.toDTO(book, BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BookDTO findByKey(Integer key) {
        return mapper.toDTO(bookRepository.findById(key), BookDTO.class);
    }

    @Override
    public BookDTO save(BookDTO obj) {
        Book book = bookRepository.save(mapper.toEntity(obj, Book.class));
        return mapper.toDTO(book, BookDTO.class);
    }

    public BookDTO saveWithPhoto(BookDTO obj, MultipartFile photo) throws IOException {
        String savedFileName = FilesHandler.saveFile(this.booksImagesFolderPath + photo.getOriginalFilename(), photo.getBytes());
        if (!photo.getOriginalFilename().equals(savedFileName)) {
            obj.setImage(savedFileName);
        }

        Book book = bookRepository.save(mapper.toEntity(obj, Book.class));

        return mapper.toDTO(book, BookDTO.class);
    }

    @Override
    public BookDTO update(Integer key, BookDTO obj) {
        Book book = mapper.toEntity(obj, Book.class);
        book.setId(key);
        bookRepository.save(book);
        return mapper.toDTO(book, BookDTO.class);
    }

    public BookDTO updateWithPhoto(Integer id, BookDTO obj, MultipartFile photo) throws IOException, NotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(()->new NotFoundException("Such book does not exist!"));
        String savedFileName = FilesHandler.updateFile(booksImagesFolderPath+book.getImage(), booksImagesFolderPath+photo.getOriginalFilename(), photo.getBytes());

        if (!photo.getOriginalFilename().equals(savedFileName)) {
            obj.setImage(savedFileName);
        }

        book = mapper.toEntity(obj, Book.class);
        book.setId(id);
        book = bookRepository.save(book);

        return mapper.toDTO(book, BookDTO.class);
    }

    @Override
    public void delete(Integer key) throws NotFoundException {
        Book book = this.bookRepository.findById(key).orElseThrow(()-> new NotFoundException("Such book does not exist!"));

        FilesHandler.deleteFile(booksImagesFolderPath + book.getImage());

        bookRepository.deleteById(key);
    }
}
