package com.payment.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    Thread t= new Thread();

    @Before("execution(* com.payment.aop.controller.Controller.getUser(..))")
    public void beforeMethod(){
        System.out.println("Hello @before aspect is called");
    }

    @After("execution(* com.payment.aop.controller.Controller.getUser(..))")
    public void afterMethod(){
        System.out.println("Hello After aspect is called");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void withinMethod(){
        System.out.println("org.springframework.stereotype.Servic is called");
    }
    @Before("args(string,int)")
    public void argsMethod(){
        System.out.println("argsMethod is called");
    }


    @Around("execution(* com.payment.aop.controller.Controller.getUserByName(..))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("argsMethod is called");
        joinPoint.proceed();
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
    }
}
