package com.pc.myblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/21 22:26
 **/
@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String TagName;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "tag_blogs",joinColumns =@JoinColumn(name = "tag_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "blog_id",referencedColumnName = "id"))
    private List<Blog> blogs ;
    private Date createAt;
    private Date updateAt;


}
