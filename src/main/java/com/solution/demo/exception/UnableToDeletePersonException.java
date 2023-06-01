package com.solution.demo.exception;

public class UnableToDeletePersonException extends RuntimeException {

    public UnableToDeletePersonException(String message) {
        super(message);
    }
}
