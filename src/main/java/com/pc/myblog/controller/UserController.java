package com.pc.myblog.controller;

import com.pc.myblog.entity.User;
import com.pc.myblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 10:24
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    /*用户列表*/
    @RequestMapping("/list")
    public String list(ModelMap modelMap,
                        @RequestParam(required = false,defaultValue = "1" )int pageIndex ,
                        @RequestParam(required = false,defaultValue = "2" )int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
//        List<Blog> all = blogService.findAll();
        Page<User> page = userService.page(pageable);
        List<User> all = page.getContent();
        int totalPages = page.getTotalPages();
        modelMap.addAttribute("totalPages",totalPages);
        modelMap.addAttribute("current",   page.getNumber());
        modelMap.addAttribute("entities",all);
        System.out.println(all);
        return "blog";
    }

    @RequestMapping("/get")
    public void  getUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.getUsername();

        logger.info(authentication.getDetails()+"");
        return;
    }

}
