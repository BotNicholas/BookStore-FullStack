package org.teamwork.spring.bookstoremvcrest.exceptions;

public class ObjectAlreadyPresentException extends Exception {

    public ObjectAlreadyPresentException() {
        super("This object is already present (id is not unique)! Better do update!");
    }

    public ObjectAlreadyPresentException(String errMessage) {
        super(errMessage);
    }
}
