package org.teamwork.spring.bookstoremvcrest.utils;

public class SqlIntegrityError {
    private String message;

    public SqlIntegrityError() {
    }

    public SqlIntegrityError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
