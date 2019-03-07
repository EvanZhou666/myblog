package com.pc.myblog.service;

import com.pc.myblog.entity.Authority;
import com.pc.myblog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/6 15:38
 **/
@Service
public class AuthorityService extends AbstractService<Authority,AuthorityRepository>{

    public AuthorityService() {
        super();
    }
    @Autowired
    public  AuthorityService(AuthorityRepository jpaRepository){
        super(jpaRepository);
    }

    public  Authority createIfNotExist (String name) {
        Authority authority = null;
        if (jpaRepository.findFirstByNameEquals(name) == null) {
            authority = jpaRepository.save(new Authority(name));
        }
        return authority;
    }
}
