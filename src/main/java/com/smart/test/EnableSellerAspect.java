package com.smart.test;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Before;


@Aspect
public class EnableSellerAspect {
//    @DeclareParents(value="com.smart.test.NaiveWaiter",
//            defaultImpl=SmartSeller.class)
//    public  Seller seller;
  //------------绑定连接点参数----------//
	@Before("target(com.smart.test.NaiveWaiter) && args(name,num,..)")
	public void bindJoinPointParams(int num,String name){
	   System.out.println("----bindJoinPointParams()----");
	   System.out.println("name:"+name);
	   System.out.println("num:"+num);
	   System.out.println("----bindJoinPointParams()----");
	}
}