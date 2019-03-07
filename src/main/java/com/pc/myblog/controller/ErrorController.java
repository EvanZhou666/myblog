package com.pc.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/5 15:43
 **/
@Controller
@RequestMapping("/error")
public class ErrorController {
    final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping("/404")
    public String error404 () {

        return "admin-404";
    }

}
