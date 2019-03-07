package com.pc.myblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 17:53
 **/
@Entity(name ="Vote")
@Data
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createAt;

    private Date updateAt;

    @OneToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="user_id")
    private User user;
}
