package com.study.transactional.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private HttpStatus status;

    // Ensure this exists!
    public ErrorResponse(Date timestamp, String message, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }
}