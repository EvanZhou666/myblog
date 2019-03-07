package com.pc.myblog.service;

import com.pc.myblog.entity.Comment;
import com.pc.myblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/22 9:28
 **/
@Service
public class CommentService extends  AbstractService<Comment,CommentRepository> {

    public CommentService() {
    }
    @Autowired
    public CommentService(CommentRepository jpaRepository) {
        super(jpaRepository);
    }
}
