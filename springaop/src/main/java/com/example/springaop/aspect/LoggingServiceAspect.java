package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingServiceAspect.class);

    @Before("execution(* com.example.springaop.service.*.getDepartmentDTO(..))")
    public void loggingBeforeGetDepartment(JoinPoint joinPoint){
        LOGGER.info("before called with args {} ", joinPoint.getArgs());
    }

    @After("execution(* com.example.springaop.service.*.getDepartmentDTO(..))")
    public void loggingAfterGetDepartment(JoinPoint joinPoint){
        LOGGER.info("after called with args {} ", joinPoint.getArgs());
    }

    @AfterThrowing("execution(* com.example.springaop.service.*.getEmployeeDTO(..))")
    public void loggingAfterGetDepartmentThrowing(JoinPoint joinPoint){
        LOGGER.info("after GetEmployeeDTO failed call !!");
    }
}
