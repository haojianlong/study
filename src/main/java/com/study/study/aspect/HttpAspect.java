package com.study.study.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(public * com.study.study.controller.CompanyTypeController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void ttt() {
        System.out.println("TTTTTTTTT");
    }

}
