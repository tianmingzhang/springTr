package com.smart.test;

@Monitorable
public class NaiveWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to "+clientName+"...");
    }
    public void serveTo(String clientName){
        System.out.println("NaiveWaiter:serving "+clientName+"...");
    }
    protected void smile(String clientName,int times){
        System.out.println("NaiveWaiter:smile to  "+clientName+ times+" times...");
    }
}
