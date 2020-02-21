package com.daiban.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: daiban
 * @description: 用户姓名实体类
 * @author: 施
 * @create: 2019-11-08 14:31
 **/

@Table(name = "user_name")
public class User_Name {

    @Id
    private Integer id;

    private String u_name;//带班人姓名

    private Integer u_id;//关联中间表

    public User_Name() {
    }

    public User_Name(Integer id, String u_name, Integer u_id) {
        this.id = id;
        this.u_name = u_name;
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "User_Name{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +
                ", u_id=" + u_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
}
