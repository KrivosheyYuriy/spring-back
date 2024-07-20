package com.example.back.domain.response;

import lombok.Getter;

@Getter
public class RestApiResponse {
    private final String message;
    private Object data;

    public RestApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public RestApiResponse(int status, String message) {
        this.message = message;
    }

}
