package com.pc.myblog.controller;

import com.pc.myblog.bean.Calculator;
import com.pc.myblog.entity.Blog;
import com.pc.myblog.entity.User;
import com.pc.myblog.service.BlogService;
import com.pc.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/18 18:21
 **/
@RestController
public class HelloController {

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    @Autowired
    Calculator calculator;
    @GetMapping("/hello")
    public String sayHello() {
        calculator.cal();
        return "hello "+LocalDate.now();
    }

    @GetMapping("/blog/findAll")
    public  List<Blog> findAll() {
        List<Blog> all = blogService.findAll();
        return all;
    }

    @GetMapping("/blog/save1")
    public Blog save() {
        Blog blog = new Blog();
        blog.setDigest("大多数优秀的程序员都是自学成才！ 服不服？ 很多人在听到这句话时，或许都会不屑一笑，毕竟这一结论的得出似乎在一定程度上抬高了非科班转行以及培训班出来的技术人，同时将科班出来的程序员们置于一个较为尴尬的位置。 但是，据最新的数据研究结果显示这一结论确实有理可依。日前，国外知名的编码对战平台 HackerRank 深入研究了全球 10351 名学生开发者的学习方式以及技能状况，并最新发布了《2018 年 Student Developer Report》。令人惊讶的是，报告显示，当前有 76% 的学生正在攻读计算机科学学位，但有 65% 的学生开发者是自学成才。那么接下来，我们将用数据说话 ");
        blog.setContent("大多数优秀的程序员都是自学成才！\n" +
                "\n" +
                "服不服？\n" +
                "\n" +
                "很多人在听到这句话时，或许都会不屑一笑，毕竟这一结论的得出似乎在一定程度上抬高了非科班转行以及培训班出来的技术人，同时将科班出来的程序员们置于一个较为尴尬的位置。\n" +
                "\n" +
                "但是，据最新的数据研究结果显示这一结论确实有理可依。日前，国外知名的编码对战平台 HackerRank 深入研究了全球 10351 名学生开发者的学习方式以及技能状况，并最新发布了《2018 年 Student Developer Report》。令人惊讶的是，报告显示，当前有 76% 的学生正在攻读计算机科学学位，但有 65% 的学生开发者是自学成才。那么接下来，我们将用数据说话。\n" +
                "--------------------- \n" +
                "作者：CSDN资讯 \n" +
                "来源：CSDN \n" +
                "原文：https://blog.csdn.net/csdnnews/article/details/85013121 \n" +
                "版权声明：本文为博主原创文章，转载请附上博文链接！ 。。。。");
        blog.setTitle("65% 的程序员竟都是自学成才？");
        blog.setCreateAt(new Date());
        User author = new User();
        author.setCreateAt(new Date());
        author.setEmail("1043056891@qq.com");
        author.setUsername("zhouzixiang");
        author = userService.save(author);
        blog.setAuthor(author);
        return blogService.save(blog);
    }
}
