package com.pc.myblog.service;

import com.pc.myblog.entity.Blog;
import com.pc.myblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 10:30
 **/
@Service
public class BlogService extends AbstractService<Blog,BlogRepository>{

    public BlogService() {
        super();//无法直接调用有参构造器
    }
    @Autowired
    public  BlogService(BlogRepository blogRepository){
        super(blogRepository);
    }
}
