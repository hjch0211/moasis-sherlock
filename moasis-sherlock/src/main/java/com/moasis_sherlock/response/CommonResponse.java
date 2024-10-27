package com.moasis_sherlock.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record CommonResponse<T>(T data, String message) {
    public static <T> ResponseEntity<CommonResponse<T>> success(T data, String message) {
        return new ResponseEntity<>(new CommonResponse<>(data, message), HttpStatus.OK);
    }

    public static <T> ResponseEntity<CommonResponse<T>> success(T data) {
        return new ResponseEntity<>(new CommonResponse<>(data, "OK"), HttpStatus.OK);
    }

    public static <T> ResponseEntity<CommonResponse<T>> error(String message, HttpStatus status) {
        return new ResponseEntity<>(new CommonResponse<>(null, message), status);
    }
}
