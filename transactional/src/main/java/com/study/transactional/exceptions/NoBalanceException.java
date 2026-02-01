package com.study.transactional.exceptions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoBalanceException extends Exception {

    public NoBalanceException(String message) {
        super(message);
        log.info("");
    }
}
