package com.sychev.coffeehouse.exception;

public class NotFoundProductException extends RuntimeException {

    private static final long serialVersionUID = -7368911869005257495L;

    public NotFoundProductException() {
        super();
    }

    public NotFoundProductException(String message) {
        super(message);
    }
}
