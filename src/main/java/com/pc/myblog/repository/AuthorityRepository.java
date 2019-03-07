package com.pc.myblog.repository;

import com.pc.myblog.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/6 15:35
 **/
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    public Authority findFirstByNameEquals(String name);

}
