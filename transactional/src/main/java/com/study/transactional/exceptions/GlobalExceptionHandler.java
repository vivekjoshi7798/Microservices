package com.study.transactional.exceptions;

import com.study.transactional.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<String> handleException(AccountNotFound exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NoBalanceException.class)
    public ResponseEntity<ErrorResponse> handleNoBalanceException(NoBalanceException exception) {
        // Create your custom response object
        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                exception.getMessage(),
                HttpStatus.PAYMENT_REQUIRED // Use .value() if your field is an int
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.PAYMENT_REQUIRED);
    }

}
