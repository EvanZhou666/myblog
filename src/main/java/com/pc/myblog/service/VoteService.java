package com.pc.myblog.service;

import com.pc.myblog.entity.Vote;
import com.pc.myblog.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/22 9:29
 **/
@Service
public class VoteService extends AbstractService<Vote,VoteRepository> {

    public VoteService() {
    }
    @Autowired
    public VoteService(VoteRepository jpaRepository) {
        super(jpaRepository);
    }
}
