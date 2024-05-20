package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class ContactDTO implements DefaultDTO {
    private Integer id;
    @NotNull(message = "Specify contact type!")
    private RefContactTypeDTO contactType;
    @NotEmpty(message = "Firstname can not be empty!")
    private String firstname;
    @NotEmpty(message = "Lastname can not be empty!")
    private String lastname;
    @NotEmpty(message = "Work phone must present")
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Number must be in format +373xxxxxxxx")
    @Length(min = 12, max = 12)
    private String workPhone;
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Number must be in format +373xxxxxxxx")
    @Length(min = 12, max = 12)
    private String cellPhone;
    private String otherDetails;

    public ContactDTO() {
    }

    public ContactDTO(RefContactTypeDTO contactType, String firstname, String lastname, String workPhone, String cellPhone, String otherDetails) {
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

    private void setId(Integer id) {
        this.id = id;
    }

    public RefContactTypeDTO getContactType() {
        return contactType;
    }

    public void setContactType(RefContactTypeDTO contactType) {
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
        return "ContactDTO{" +
                "id=" + id +
                ", contactTypeCode=" + contactType +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
