package org.teamwork.spring.bookstoremvcrest.utils;

public class UsedIdError {
    private String message;

    public UsedIdError() {
        this.message = "This identifier is already used, therefore such object is already present." +
                "Use update to modify it.";
    }

    public UsedIdError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
