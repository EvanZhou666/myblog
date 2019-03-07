package com.pc.myblog.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * String name() default "";   (Optional) 外键列名
 *
 * 1、如果join是使用外键关联策略是一对一或者是多对一关系，外键列是关联的存在于源实体的表中。
 *
 * 2、如果join是一对多的单向映射，则外键位于目标实体的表中。
 *
 * 3、如果join是多对多、一对一、双向的多对一和一对多，外键位于中间表中
 *
 * 4、如果join用于集合，则外键位于集合表中。
 *
 * 默认情况下（在单个连接下适用）
 * 引用方（主控方）的实体属性名或字段名_被引用的主键名。
 *
 * 如果实体中没有referencing属性或字段，或者join用于集合， join 名称按下列规则构成：
 * 实体名_被引用的主键列名
 */


/**
 * String referencedColumnName() default ""; (Optional)  被引用的外键列名
 *
 * 1、当与这里描述的案例之外的实体关系映射一起使用时，引用的列位于目标实体的表中。
 *
 * 2、当单向的使用一对多映射策略是，被引用的列位于源实体中。
 *
 * 3、当在JoinTable注解内部使用时，引用的键列位于所属实体的实体表中，如果连接是反向连接定义的一部分，则为位于反向实体。
 *
 * 4、当用于CollectionTable下的映射时，被引用的列名位于包含该集合的实体类中。
 *
 * 默认情况下（仅使用与单连接情况下）
 * 名称和被引用的表中主键列名一致
 */

@Entity(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length=1000)
    private String digest;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User author;

    @OneToMany()
    @JoinColumn(name = "blog_id",referencedColumnName = "id")
    private Set<Comment> comments = new HashSet<>();
    @Lob
    @Basic(fetch=LAZY)
    private String content;

    private Date createAt;

    private Date updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}

