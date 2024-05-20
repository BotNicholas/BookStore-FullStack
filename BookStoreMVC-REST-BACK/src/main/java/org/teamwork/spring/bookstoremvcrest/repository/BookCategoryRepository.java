package org.teamwork.spring.bookstoremvcrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamwork.spring.bookstoremvcrest.model.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
