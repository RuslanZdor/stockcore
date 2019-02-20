package com.stocker.exception;

public class NoMarketException extends Exception {
    public NoMarketException() {
        super();
    }

    public NoMarketException(String message) {
        super(message);
    }

    public NoMarketException(String message, Throwable cause) {
        super(message, cause);
    }
}
