package com.moasis_sherlock.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonExceptionImpl extends RuntimeException {
    private final HttpStatus status;

    CommonExceptionImpl(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}