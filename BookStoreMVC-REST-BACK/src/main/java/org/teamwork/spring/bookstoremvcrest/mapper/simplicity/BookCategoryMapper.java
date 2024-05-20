package org.teamwork.spring.bookstoremvcrest.mapper.simplicity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teamwork.spring.bookstoremvcrest.model.BookCategory;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookCategoryDTO;

@Component
public class BookCategoryMapper implements DefaultMapper<BookCategoryDTO, BookCategory> {
    @Autowired
    private ModelMapper mapper;

    @Override
    public BookCategory toEntity(BookCategoryDTO dto) {
        return (dto == null) ? null : mapper.map(dto, BookCategory.class);
    }

    @Override
    public BookCategoryDTO toDTO(BookCategory entity) {
        return (entity == null) ? null : mapper.map(entity, BookCategoryDTO.class);
    }
}
