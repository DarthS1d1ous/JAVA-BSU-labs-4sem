package com.borschevskydenis.lab4;

public class IdentificationException extends Exception {
    private Exception identification;

    public Exception getIdentification() {
        return identification;
    }

    public IdentificationException(String message) {
        super(message);
    }

    public IdentificationException() {
        super();
    }

    public IdentificationException(String message, Exception e) {
        super(message);
        identification = e;
    }
}
