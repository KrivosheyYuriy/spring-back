package com.example.back.domain.exception;

public abstract class RestApiException extends RuntimeException {
    public RestApiException(String message) {
        super(message);
    }
}
