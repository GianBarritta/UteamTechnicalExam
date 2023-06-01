package com.solution.demo.exception;

public class UnableToFoundPersonException extends RuntimeException{

    public UnableToFoundPersonException(String message){
        super(message);
    }
}
