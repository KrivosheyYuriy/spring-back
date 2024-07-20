package com.example.back.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public final class NotFoundException extends RestApiException {
    public NotFoundException(String message) {
        super(message);
    }
}