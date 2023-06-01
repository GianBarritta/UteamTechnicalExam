package com.solution.demo.exception;

public class UnableToDeleteEntityException extends RuntimeException {

    public UnableToDeleteEntityException(String message) {
        super(message);
    }
}
