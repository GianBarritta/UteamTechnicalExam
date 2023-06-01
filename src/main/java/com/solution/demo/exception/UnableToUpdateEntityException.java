package com.solution.demo.exception;

public class UnableToUpdatePersonException extends RuntimeException{

    public UnableToUpdatePersonException(String message) {
        super(message);
    }
}
