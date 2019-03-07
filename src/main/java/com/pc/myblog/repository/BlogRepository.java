package com.pc.myblog.repository;

import com.pc.myblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 10:21
 **/
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
