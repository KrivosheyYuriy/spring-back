package com.example.back.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public final class InvalidDataException extends RestApiException{
    public InvalidDataException(String message) {
        super(message);
    }
}
