package com.solution.demo.exception;

public class UnableToUpdateEntityException extends RuntimeException{

    public UnableToUpdateEntityException(String message) {
        super(message);
    }
}
