package com.pc.myblog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//ElementType.TYPE //可以注入在接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Logweb {
    String value() default "";
}
