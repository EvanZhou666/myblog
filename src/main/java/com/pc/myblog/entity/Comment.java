package com.pc.myblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 17:50
 **/
@Entity(name = "Comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String commentContent;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    private Date createAt;

    private Date updateAt;

}
