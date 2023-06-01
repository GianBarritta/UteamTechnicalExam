package com.solution.demo.exception;

public class UnableToFoundEntityException extends RuntimeException{

    public UnableToFoundEntityException(String message){
        super(message);
    }
}
