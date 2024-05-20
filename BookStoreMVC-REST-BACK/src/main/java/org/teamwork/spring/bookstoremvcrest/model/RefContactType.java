package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "ref_contact_types")
public class RefContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @NotEmpty(message = "You must specify contact type")
    @Column(name = "contact_type_description")
    private String contactTypeDescription;
    @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    public RefContactType() {
    }

    public RefContactType(String contactTypeDescription) {
        this.contactTypeDescription = contactTypeDescription;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContactTypeDescription() {
        return contactTypeDescription;
    }

    public void setContactTypeDescription(String contactTypeDescription) {
        this.contactTypeDescription = contactTypeDescription;
    }

    @Override
    public String toString() {
        return "RefContactType{" +
                "code=" + code +
                ", contactTypeDescription='" + contactTypeDescription + '\'' +
                '}';
    }
}
