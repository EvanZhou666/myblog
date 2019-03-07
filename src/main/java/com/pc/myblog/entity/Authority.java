package com.pc.myblog.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/3/6 14:21
 **/
@Entity
public class Authority implements GrantedAuthority {

    protected Authority(){}

    public Authority(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
