package org.teamwork.spring.bookstoremvcrest.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookCategoryDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.BookCategoryServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class BookCategoryController {
    private final BookCategoryServiceImpl categoryService;

    public BookCategoryController(BookCategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<BookCategoryDTO> findAll(@RequestParam(value = "filter", required = false) String filter) {
        if (filter == null)
            return categoryService.findAll();
        return categoryService.filter(filter);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookCategoryDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        BookCategoryDTO bookCategoryDTO = categoryService.findByKey(id);
        if (bookCategoryDTO == null) {
            throw new NotFoundException();
        }
        return bookCategoryDTO;
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookCategoryDTO save(@Valid @RequestBody BookCategoryDTO categoryDTO) throws UnexpectedIdException {
        if (categoryDTO.getCode() != null && categoryDTO.getCode() != 0) {
            throw new UnexpectedIdException();
        }
        System.out.println(categoryDTO);
        return categoryService.save(categoryDTO);
    }

    @PatchMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookCategoryDTO update(@Valid @RequestBody BookCategoryDTO categoryDTO, @PathVariable("id") Integer id) {
        return categoryService.update(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return "Success!";
    }
}