package com.study.transactional.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start= System.currentTimeMillis();
        System.out.println("Method Started "+ joinPoint.getSignature());

        Object result= joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        System.out.println("⏱ Method Completed in " + duration + " ms");

        return result;
    }


}
