package com.example.back.domain.exception.handler;

import com.example.back.domain.response.RestApiResponse;
import com.example.back.domain.exception.InvalidDataException;
import com.example.back.domain.exception.NotFoundException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RestApiResponseHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> handleException(NotFoundException e){
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
