package com.pc.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 15:54
 **/
@Controller
@RequestMapping("/admin/")
public class AdminController {
    @RequestMapping("index")

    public String index (ModelMap modelMap) {
        return "admin-index";
    }

    @RequestMapping("form")
    public String form (ModelMap modelMap) {
        return "admin-form";
    }

    @RequestMapping("help")
    public String help (ModelMap modelMap) {
        return "admin-help";
    }

    @RequestMapping("table")
    public String table (ModelMap modelMap) {
        return "admin-table";
    }



}
