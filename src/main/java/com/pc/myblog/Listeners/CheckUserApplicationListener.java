package com.pc.myblog.Listeners;

import com.pc.myblog.entity.Authority;
import com.pc.myblog.entity.User;
import com.pc.myblog.service.AuthorityService;
import com.pc.myblog.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/25 17:37
 **/
@Component
public class CheckUserApplicationListener implements ApplicationListener<ContextRefreshedEvent>,ApplicationContextAware {

    ApplicationContext applicationContext;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
          System.out.println("检查应用是否存在默认用户，没有则创建");
        UserService userService = applicationContext.getBean(UserService.class);
        AuthorityService authorityService = applicationContext.getBean(AuthorityService.class);
        Authority role_admin = authorityService.createIfNotExist("ROLE_ADMIN");
        System.out.println(userService == null);
           if (userService.findFirstByEmailEquals("1@qq.com") == null) {
               User u = new User();
               u.setUsername("EvanZhou");
               u.setEmail("1@qq.com");
               u.setPassword("111");
               HashSet<Authority> set = new HashSet<>();
               set.add(role_admin);
               u.setAuthorities(set);
               userService.save(u);
            }

//            创建普通用户
        if (userService.findFirstByEmailEquals("2@qq.com") == null) {
            User u = new User();
            u.setUsername("EvanZhou2");
            u.setEmail("2@qq.com");
            u.setPassword("111");
            userService.save(u);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
