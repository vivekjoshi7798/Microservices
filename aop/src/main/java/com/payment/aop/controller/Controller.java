package com.payment.aop.controller;

import com.payment.aop.service.HippoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class Controller {

    @Autowired
    HippoService hippoService;

    @GetMapping(path="/fetchUser/{firstId}")
    public String getUser(@PathVariable(name="firstId") int id ){
        System.out.println("getUser method called with id: " + id);
        hippoService.getHippoDetails();
        hippoService.getHippoDetails("vivek",123);
        return "Employee 1 is Returned";
    }

    @GetMapping(path="/fetchUserByName/{firstName}")
    public String getUserByName(@PathVariable(name="firstName") String firstName ){
        System.out.println("getUser method called with id: " + firstName);
        return "Employee 1 is Returned";
    }


}
