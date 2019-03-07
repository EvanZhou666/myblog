package com.pc.myblog.controller;

import com.pc.myblog.properties.SecurityProperties;
import com.pc.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 10:24
 **/
@Controller
public class LoginController {
    @Autowired
    SecurityProperties securityProperties;
    @Autowired
    UserService userService;
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String login(String email,String password) {
//        System.out.println("属性文件："+securityProperties.getSuccessRedirect()+" "+securityProperties.getLoginType());
        return "index";
    }
}
