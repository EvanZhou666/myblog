package com.pc.myblog.controller;

import com.pc.myblog.entity.Blog;
import com.pc.myblog.entity.User;
import com.pc.myblog.service.BlogService;
import com.pc.myblog.service.UserService;
import com.pc.myblog.util.ResponseUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/19 10:24
 **/
@Controller
@RequestMapping("/blog")
public class BlogController {
    final Logger logger = LoggerFactory.getLogger(BlogController.class);
    @Autowired
    UserService userService;
    /*博客页*/
    @RequestMapping("/list")
    public String list(ModelMap modelMap,
                        @RequestParam(required = false,defaultValue = "1" )int pageIndex ,
                        @RequestParam(required = false,defaultValue = "2" )int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
//        List<Blog> all = blogService.findAll();
        Page<Blog> page = blogService.page(pageable);
        List<Blog> all = page.getContent();
        int totalPages = page.getTotalPages();
        modelMap.addAttribute("totalPages",totalPages);
        modelMap.addAttribute("current",   page.getNumber());
        modelMap.addAttribute("entities",all);
        System.out.println(all);
        return "blog";
    }
    /*博客详情*/


    @Autowired
            BlogService blogService;
    @RequestMapping("/blogDetail")
    public String sidebar(@RequestParam(required = true,defaultValue = "0" ) Integer id , ModelMap modelMap) {
        Blog blog = blogService.getOne(id);
        System.out.println("blog======"+blog);
        modelMap.addAttribute("item",blog);
        return "blog-detail";
    }

    /*写博客*/
    @RequestMapping("/mark")
    public String mark (ModelMap modelMap) {
        return "mark";
    }

    /*首页 landing*/
    @RequestMapping("/landing")
    public String landing (ModelMap modelMap) {
        return "landing";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseUtils<Object> save(String digest , String title, String content) {
        logger.info("----- "+digest+"  "+title+"  "+content);
        Blog blog = new Blog();
        blog.setDigest(digest);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setCreateAt(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        blog.setAuthor(user);
        blogService.save(blog);
        System.out.println("保存成功");
        return ResponseUtils.success("保存文章成功");
    }

}
