package com.pc.myblog.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 8:59
 **/
//@Aspect
public class MyAspect {

    @Pointcut("execution(* com.pc.myblog.bean.Calculator.*(..))")
    public void pointCut(){

    }
    @Before(value = "pointCut()")
    public void  callBefore() {
        System.out.println("前置通知");
    }

    @After(value = "pointCut()")
    public void callAfter() {
        System.out.println("后置通知");
    }

  /*  @Around(value = "pointCut()")
    public void round(JoinPoint joinPoint){
        System.out.println("环绕通知");
    }*/

}
