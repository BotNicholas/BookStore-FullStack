package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class BookCategoryDTO implements DefaultDTO {
    private Integer code;
    @NotEmpty(message = "Category must be specified!")
    private String categoryDescription;

    public BookCategoryDTO() {
    }

    public BookCategoryDTO(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
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
        return "BookCategoryDTO{" +
                "code=" + code +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
