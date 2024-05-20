package org.teamwork.spring.bookstoremvcrest.utils;

public class NotFoundError {
    private String message;

    public NotFoundError() {
        this.message = "Such object was not found";
    }

    public NotFoundError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}