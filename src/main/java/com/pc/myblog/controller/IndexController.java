package com.pc.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 10:11
 **/
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "test";
    }
}
