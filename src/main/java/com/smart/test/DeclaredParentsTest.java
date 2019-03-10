package com.smart.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DeclaredParentsTest {

    @Test
    public void parent() {
        String configPath = "bean.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        NaiveWaiter naiveWaiter = (NaiveWaiter)ctx.getBean("naiveWaiter");
        //CuteNaiveWaiter cuteNaiveWaiter = (CuteNaiveWaiter)ctx.getBean("cuteNaiveWaiter");
        //((NaiveWaiter)waiter).smile("John",2);
        //waiter.smile("John",1);
        //System.out.println("cuteNaiveWaiter's class is "+cuteNaiveWaiter.getClass().getName());
        //System.out.println("cuteNaiveWaiter have annotation is "+cuteNaiveWaiter.getClass().isAnnotationPresent(Monitorable.class));

        System.out.println("naiveWaiter's class is "+naiveWaiter.getClass());
        try {
            System.out.println("naiveWaiter's class is " + naiveWaiter.getClass().getDeclaredMethod("smile",String.class,int.class));
        } catch (NoSuchMethodException e) {
            System.out.println("no smile method");
        }
        naiveWaiter.smile("ddd",111);
//        Method[] methods = naiveWaiter.getClass().getDeclaredMethods();
//        for (int i = 0;i<methods.length;i++) {
//            System.out.println(methods[i]);
//             }

        //System.out.println("naiveWaiter have annotation is "+naiveWaiter.getClass().getSuperclass().isAnnotationPresent(Monitorable.class));
        //NaiveWaiter naiveWaiter1 = new NaiveWaiter ();
        //Annotation[] annotations =  naiveWaiter1.getClass().getAnnotations();
        //System.out.println("naiveWaiter have annotation is "+annotations.length);
        //for (int i = 0;i<annotations.length;i++) {
            //System.out.println(annotations[i]);
       // }

//        CuteNaiveWaiter cuteNaiveWaiter1 = new CuteNaiveWaiter ();
//        System.out.println("cuteNaiveWaiter have annotation is "+cuteNaiveWaiter1.getClass().isAnnotationPresent(Monitorable.class));
       //naiveWaiter.greetTo("222");

        //cuteNaiveWaiter.greetTo("111");
//        Seller seller = (Seller)waiter;
//        seller.sell("Beer", "John");
    }
}
