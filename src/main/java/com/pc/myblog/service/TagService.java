package com.pc.myblog.service;

import com.pc.myblog.entity.Tag;
import com.pc.myblog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/22 9:29
 **/
@Service
public class TagService extends AbstractService<Tag,TagRepository> {

    public TagService() {
    }

    @Autowired
    public TagService(TagRepository jpaRepository) {
        super(jpaRepository);
    }
}
