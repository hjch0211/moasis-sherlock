package com.moasis_sherlock.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommonException {
    ID_NOT_FOUND(new CommonExceptionImpl(HttpStatus.NOT_FOUND, "id를 찾을 수 없습니다.")),
    ID_DUPLICATED(new CommonExceptionImpl(HttpStatus.CONFLICT, "id가 중복되었습니다."));
    
    private final CommonExceptionImpl exception;

    // [Temp] toException() 메서드을 사용하지 않을 수 없을까
    public CommonExceptionImpl toException() {
        return exception;
    }
}