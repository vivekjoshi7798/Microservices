package com.payment.aop.service;

import org.springframework.stereotype.Service;

@Service
public class HippoService {


    public void getHippoDetails(){
        System.out.println("Hippo details are fetched");
    }

    public void getHippoDetails(String vivek, int i) {
        System.out.println("Hippo details with args are fetched");
    }
}
