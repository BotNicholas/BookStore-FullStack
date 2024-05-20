package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Specify contact type!")
    @ManyToOne
    @JoinColumn(name = "contact_type_code", referencedColumnName = "code")
    private RefContactType contactType;
    @NotEmpty(message = "Firstname can not be empty!")
    private String firstname;
    @NotEmpty(message = "Lastname can not be empty!")
    private String lastname;
    @NotEmpty(message = "Work phone must present")
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Number must be in format +373xxxxxxxx")
    @Length(min = 12, max = 12)
    @Column(name = "work_phone")
    private String workPhone;
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Number must be in format +373xxxxxxxx")
    @Length(min = 12, max = 12)
    @Column(name = "cell_phone")
    private String cellPhone;
    @Column(name = "other_details")
    private String otherDetails;

    public Contact() {
    }

    public Contact(RefContactType contactType, String firstname, String lastname, String workPhone, String cellPhone, String otherDetails) {
        this.contactType = contactType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.workPhone = workPhone;
        this.cellPhone = cellPhone;
        this.otherDetails = otherDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RefContactType getContactType() {
        return contactType;
    }

    public void setContactType(RefContactType contactType) {
        this.contactType = contactType;
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

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactType=" + contactType +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
