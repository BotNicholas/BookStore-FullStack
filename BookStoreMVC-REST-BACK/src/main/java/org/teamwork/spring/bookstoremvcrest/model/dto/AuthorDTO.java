package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorDTO implements DefaultDTO {
    private Integer id;
    @NotEmpty(message = "Firstname can not be empty!")
    private String firstname;
    @NotEmpty(message = "Lastname can not be empty!")
    private String lastname;
    @NotEmpty(message = "Only 2 symbols for initials are required!")
    @Length(min = 2, max = 2)
    private String initials;
    @NotNull(message = "Birthdate must be specified!")
    private LocalDate birthDate;
    @NotNull(message = "Gender must be specified!")
    @Pattern(regexp = "^[MFU]$", message = "Gender must be in uppercase and only M(ale), F(emale) or U(ndefined)!")
    private String gender;
    private String contactDetails;
    private String otherDetails;
    private String image;
    private List<Integer> books;

    public AuthorDTO() {
        this.image = "Placeholder.png";
        this.books = new ArrayList<>();
    }

    public AuthorDTO(String firstname, String lastname, String initials, LocalDate birthDate, String gender, String contactDetails, String otherDetails) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.initials = initials;
        this.birthDate = birthDate;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.otherDetails = otherDetails;
        this.image = "Placeholder.png";
        this.books = new ArrayList<>();
    }

    public AuthorDTO(String firstname, String lastname, String initials, LocalDate birthDate, String gender, String contactDetails, String otherDetails, List<Integer> books, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.initials = initials;
        this.birthDate = birthDate;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.otherDetails = otherDetails;
        this.books = books;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(List<Integer> books) {
        this.books = books;
    }

    public void addBook(Integer bookId) {
        books.add(bookId);
    }

    @Override
    public String toString() {
        return "AuthorDAO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", initials='" + initials + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", contactDetails='" + contactDetails + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", image='" + image + '\'' +
                ", books=" + books +
                '}';
    }
}
