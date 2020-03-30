package com.eduit.springbootdataaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.eduit.springbootdataaop.repository.ProductRepository.f*(..))")
    public void logRepositoryMethodCalls(){}

    @Pointcut("execution(* com.eduit.springbootdataaop.repository.ProductRepository.s*(..))")
    public void logAnyClassWithAnnotationPerformanceCheckAble() {}

    @Before("logRepositoryMethodCalls()")
    public void beforeMethodAdvice(JoinPoint joinPoint) {
        System.out.println("");
        System.out.println("*****************************************************************");

        System.out.println("Method Signature: "  + joinPoint.getSignature ().getName ());
    }

    @Around("logAnyClassWithAnnotationPerformanceCheckAble()")
    public Object aroundAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("");
        long start = System.currentTimeMillis();

        System.out.println("Printing save parameter " + Arrays.toString(proceedingJoinPoint.getArgs()));

        Object response = proceedingJoinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("Saving in database " + proceedingJoinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        System.out.println("");

        return response;
    }
}
