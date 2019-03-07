package com.pc.myblog.service;

import com.pc.myblog.entity.User;
import com.pc.myblog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/22 9:29
 **/
@Service
public class UserService extends AbstractService<User,UserRepository> implements UserDetailsService {
   final Logger logger = LoggerFactory.getLogger(UserService.class);

/*    @Autowired
    private PasswordEncoder passwordEncoder;*/
    public UserService() {
    }
    @Autowired
    public UserService(UserRepository jpaRepository) {
        super(jpaRepository);
    }

    @Transactional
    public User findFirstByEmailEquals(String email) {
        return  jpaRepository.findFirstByEmailEquals(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("邮箱名:"+email);
        User user = findFirstByEmailEquals(email);
        if (user ==null) {
            logger.info("未登录用户："+email);
        } else {
            logger.info("找到用户:"+user.getUsername());
        }
        return user;
    }

}
