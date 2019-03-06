package com.smart.test;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;


@Aspect
public class EnableSellerAspect {
    @DeclareParents(value="com.smart.test.NaiveWaiter",
            defaultImpl=SmartSeller.class)
    public  Seller seller;
}