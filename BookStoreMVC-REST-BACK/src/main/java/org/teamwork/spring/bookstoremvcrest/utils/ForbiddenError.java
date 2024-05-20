package org.teamwork.spring.bookstoremvcrest.utils;

public class ForbiddenError {
    private String message;

    public ForbiddenError() {
        this.message = "oops! You can't visit this page ;-)";
    }

    public ForbiddenError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ForbiddenError{" +
                "message='" + message + '\'' +
                '}';
    }
}
