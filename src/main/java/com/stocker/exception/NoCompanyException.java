package com.stocker.exception;

public class NoCompanyException extends RuntimeException {

    public NoCompanyException(String message) {
        super(message);
    }

    public NoCompanyException() {
        super();
    }

    public NoCompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}
