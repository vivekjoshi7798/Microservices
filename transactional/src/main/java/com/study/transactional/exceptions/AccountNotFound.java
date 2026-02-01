package com.study.transactional.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountNotFound extends Exception{

    public AccountNotFound(String message) {
        super(message);
        log.info("Account Not Found");
    }
}
