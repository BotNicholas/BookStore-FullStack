package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "book_categories")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @NotEmpty(message = "Category must be specified!")
    @Column(name = "category_description")
    private String categoryDescription;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

    public BookCategory() {
    }

    public BookCategory(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "code=" + code +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
