package com.moasis_sherlock.exception;


import com.moasis_sherlock.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CommonResponse<String>> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return CommonResponse.error("알 수 없는 에러가 발생하였습니다. 관리자에게 문의주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommonExceptionImpl.class)
    public ResponseEntity<CommonResponse<String>> handleCommonExceptionImpl(CommonExceptionImpl e) {
        log.error(e.getMessage(), e);
        return CommonResponse.error(e.getMessage(), e.getStatus());
    }
}
