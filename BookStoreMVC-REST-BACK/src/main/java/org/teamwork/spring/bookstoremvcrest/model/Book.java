package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Author must be specified!")
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @NotNull(message = "Book category must be specified!")
    @ManyToOne
    @JoinColumn(name = "book_category_code", referencedColumnName = "code")
    private BookCategory category;
    @NotEmpty(message = "ISBN can not be empty!")
    @Pattern(regexp = "^\\d{3}-\\d-\\d{2}-\\d{6}-\\d$", message = "ISBN must be in format: xxx-x-xx-xxxxxx-x")
    @Length(min = 17, max = 17)
    private String isbn;
    @NotNull(message = "Publication date must be specified!")
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @NotNull(message = "Acquiring date must be specified!")
    @Column(name = "date_aquired")
    private LocalDate dateAcquired;
    @NotEmpty(message = "Specify the title!")
    private String title;
    @Min(value = 0, message = "Price must be > than 0")
    @Column(name = "recommended_price")
    private Double recommendedPrice;
    private String comments;
    private String image;

    public Book() {
    }

    public Book(Author author, BookCategory category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments) {
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

    public Book(Author author, BookCategory category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments, String image) {
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

    public Book(Integer id, Author author, BookCategory category, String isbn, LocalDate publicationDate, LocalDate dateAcquired, String title, Double recommendedPrice, String comments, String image) {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
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
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", category=" + category +
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
