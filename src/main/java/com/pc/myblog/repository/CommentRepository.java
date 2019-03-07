package com.pc.myblog.repository;

import com.pc.myblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/22 9:13
 **/
public interface CommentRepository  extends JpaRepository<Comment,Integer> {

}
