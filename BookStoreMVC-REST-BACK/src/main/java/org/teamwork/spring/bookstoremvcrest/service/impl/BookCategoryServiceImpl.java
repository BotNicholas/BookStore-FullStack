package org.teamwork.spring.bookstoremvcrest.service.impl;

import org.springframework.stereotype.Service;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapper;
import org.teamwork.spring.bookstoremvcrest.model.BookCategory;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookCategoryDTO;
import org.teamwork.spring.bookstoremvcrest.repository.BookCategoryRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookCategoryServiceImpl implements DefaultService<BookCategoryDTO, BookCategory, Integer> {
    private final BookCategoryRepository bookCategoryRepository;
    private final AbstractMapper mapper;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository, AbstractMapper mapper) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookCategoryDTO> findAll() {
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();
        return bookCategories.stream().map(bookCategory -> mapper.toDTO(bookCategory, BookCategoryDTO.class)).collect(Collectors.toList());
    }

    public List<BookCategoryDTO> filter(String filter) {
        List<BookCategory> categories = Collections.EMPTY_LIST;

        if (false) {
            //...
        } else {
            categories = bookCategoryRepository.findAll();
        }

        return categories.stream().map(bookCategory -> mapper.toDTO(bookCategory, BookCategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BookCategoryDTO findByKey(Integer key) {
        return mapper.toDTO(bookCategoryRepository.findById(key), BookCategoryDTO.class);
    }

    @Override
    public BookCategoryDTO save(BookCategoryDTO obj) {
        BookCategory bookCategory = bookCategoryRepository.save(mapper.toEntity(obj, BookCategory.class));
        return mapper.toDTO(bookCategory, BookCategoryDTO.class);
    }

    @Override
    public BookCategoryDTO update(Integer key, BookCategoryDTO obj) {
        BookCategory bookCategory = mapper.toEntity(obj, BookCategory.class);
        bookCategory.setCode(key);
        bookCategoryRepository.save(bookCategory);
        return mapper.toDTO(bookCategory, BookCategoryDTO.class);
    }

    @Override
    public void delete(Integer key) {
        bookCategoryRepository.deleteById(key);
    }
}
