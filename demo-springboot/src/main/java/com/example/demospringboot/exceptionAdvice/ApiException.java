package com.example.demospringboot.exceptionAdvice;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
