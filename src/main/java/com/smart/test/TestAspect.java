package com.smart.test;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    @AfterReturning("execution( * com.smart.test.NaiveWaiter.*(..))")
    public void thisTest(){
        System.out.println("thisTest() executed!");
    }
}
