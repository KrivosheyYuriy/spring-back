package com.example.back.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public final class HasDependencies extends RestApiException {
    public HasDependencies(String message) {
        super(message);
    }
}
