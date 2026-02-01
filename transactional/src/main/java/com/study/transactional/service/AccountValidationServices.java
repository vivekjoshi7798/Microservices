package com.study.transactional.service;

import com.study.transactional.entity.Account;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountValidationServices {

    public void validateMoney(Account sender,BigDecimal amount) {
        try {
            log.info("Money Transfer process begin");
            Thread.sleep(200000);
            if(sender.getBalance().compareTo(amount)<0){
                throw new RuntimeException("Don't have Money in Sender");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void sendNotification() {

        try {

            Thread.sleep(200000);
            log.info("Money Transfer process Done ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
