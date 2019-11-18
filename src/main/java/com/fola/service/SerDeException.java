package com.fola.service;

public class SerDeException extends RuntimeException {

    public SerDeException() {
        super();
    }

    public SerDeException(String message) {
        super(message);
    }

    public SerDeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerDeException(Throwable cause) {
        super(cause);
    }

    protected SerDeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
