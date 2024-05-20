package org.teamwork.spring.bookstoremvcrest.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class RefContactTypeDTO implements DefaultDTO {
    private Integer code;
    @NotEmpty(message = "You must specify contact type")
    private String contactTypeDescription;

    public RefContactTypeDTO() {
    }

    public RefContactTypeDTO(String contactTypeDescription) {
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
        return "RefContactTypeDTO{" +
                "code=" + code +
                ", contactTypeDescription='" + contactTypeDescription + '\'' +
                '}';
    }
}
