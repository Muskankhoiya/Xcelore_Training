package com.example.microservices.exceptionhandling;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
