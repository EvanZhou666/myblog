package com.pc.myblog.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 11:32
 **/

//@Aspect
public class LogWebAspect {
    Logger logger = LoggerFactory.getLogger(LogWebAspect.class);

    @Pointcut("execution(* com.pc.myblog.controller.BlogController.*(..))")
    public void logPoint(){}

    @Before("logPoint()")
   public void  doBefore (JoinPoint joinPoint) {
       logger.info("========begin to print log=========");
       ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       logger.info(LocalDateTime.now()+" | "+request.getRequestURI()+" | "+request.getMethod()+"|"+joinPoint.getSignature().getDeclaringTypeName() + " | "+ Arrays.toString(joinPoint.getArgs()));
//       System.out.println(LocalDateTime.now()+" | "+request.getRequestURI()+" | "+request.getMethod()+"|"+joinPoint.getSignature().getDeclaringTypeName() + " | "+ Arrays.toString(joinPoint.getArgs()));
   }

    @AfterReturning(returning = "returnValue", pointcut = "logPoint()")
    public void doAfterReturning(Object returnValue) throws Throwable {
        // 处理完请求，返回内容
        logger.info("===========RESPONSE========: " + returnValue);
//        System.out.println("===========RESPONSE========: " + returnValue);
    }

}
