package com.pc.myblog.repository;

import com.pc.myblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer> {
    public User findFirstByEmailEquals(String email);

    public User findFirstByUsernameEquals (String username);
}
