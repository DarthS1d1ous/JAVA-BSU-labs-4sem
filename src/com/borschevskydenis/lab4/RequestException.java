package com.borschevskydenis.lab4;

public class RequestException extends Exception {
    public Exception getRequest() {
        return request;
    }

    private Exception request;
    public RequestException() {
        super();
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Exception e) {
        super(message);
        request = e;
    }
}
