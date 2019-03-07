package com.pc.myblog.config;

import com.pc.myblog.AOP.LogWebAspect;
import com.pc.myblog.AOP.MyAspect;
import com.pc.myblog.bean.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 9:03
 **/
@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public MyAspect myAspect() {
        return  new MyAspect();
    }

    @Bean
    public LogWebAspect logWebAspect(){
        return new LogWebAspect();
    }

}
