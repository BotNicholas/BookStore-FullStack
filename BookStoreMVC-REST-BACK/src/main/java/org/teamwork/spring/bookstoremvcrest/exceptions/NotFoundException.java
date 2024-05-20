package org.teamwork.spring.bookstoremvcrest.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Such object was not found!");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
