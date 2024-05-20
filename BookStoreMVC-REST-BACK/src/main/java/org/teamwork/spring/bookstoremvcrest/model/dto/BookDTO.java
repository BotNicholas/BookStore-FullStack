package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class BookDTO implements DefaultDTO {
    private Integer id;
    @NotNull(message = "Author must be specified!")
    private AuthorDTO author;
    @NotNull(message = "Book category must be specified!")
    private BookCategoryDTO category;
    @NotEmpty(message = "ISBN can not be empty!")
    @Pattern(regexp = "^\\d{3}-\\d-\\d{2}-\\d{6}-\\d$", message = "ISBN must be in format: xxx-x-xx-xxxxxx-x")
    @Length(min = 17, max = 17)
    private String isbn;
    @NotNull(message = "Publication date must be specified!")
    private LocalDate publicationDate;
    @NotNull(message = "Acquiring date must be specified!")
    private LocalDate dateAcquired;
    @NotEmpty(message = "Specify the title!")
    private String title;
    @Min(value = 0, message = "Price must be > than 0")
    private Double recommendedPrice;
    private String comments;

    private String image;

    public BookDTO() {
    }

    public BookDTO(AuthorDTO author, BookCategoryDTO category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments) {
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.dateAcquired = dateAcquired;
        this.title = title;
        this.recommendedPrice = recommendedPrice;
        this.comments = comments;
        this.image = "Placeholder.png";
    }

    public BookDTO(AuthorDTO author, BookCategoryDTO category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments, String image) {
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.dateAcquired = dateAcquired;
        this.title = title;
        this.recommendedPrice = recommendedPrice;
        this.comments = comments;
        this.image = image;
    }

    public BookDTO(Integer id, AuthorDTO author, BookCategoryDTO category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments, String image) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.dateAcquired = dateAcquired;
        this.title = title;
        this.recommendedPrice = recommendedPrice;
        this.comments = comments;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public BookCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(BookCategoryDTO category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDate getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(LocalDate dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(Double recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", authorId=" + author +
                ", categoryCode=" + category +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", dateAcquired=" + dateAcquired +
                ", title='" + title + '\'' +
                ", recommendedPrice=" + recommendedPrice +
                ", comments='" + comments + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
