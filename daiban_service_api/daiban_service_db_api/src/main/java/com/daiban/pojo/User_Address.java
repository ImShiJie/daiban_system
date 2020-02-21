package com.daiban.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: daiban
 * @description:
 * @author: 施
 * @create: 2019-11-03 08:54
 **/
@Table(name = "user_address")
public class User_Address {

    @Id
    private Integer id;
    private String address;//带班地址
    private Integer address_id;//关联中间表

    public User_Address() {
    }

    public User_Address(Integer id, String address, Integer address_id) {
        this.id = id;
        this.address = address;
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "User_Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address_id=" + address_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }
}
