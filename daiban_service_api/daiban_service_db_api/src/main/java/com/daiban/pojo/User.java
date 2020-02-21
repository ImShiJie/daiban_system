package com.daiban.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: daiban
 * @description: 用户详情页实体类
 * @author: 施
 * @create: 2019-11-03 12:35
 **/

@Table(name = "user")
public class User {

    @Id
    private Integer u_id;//用户id
    private String u_name;//用户姓名
    private String u_address;//用户地址
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date u_date;//带班时间
    private Double u_day;//带班天数，0.5天或者1天
    private Integer u_money;//带班价格
    private Integer u_overtime;//加班时长
    private Integer u_tower_crane;//带的那一台
    private Integer u_money_start;//金钱支付状态
    private Integer u_address_id;//关联地址
    private Integer u_user_id;//关联姓名

    public User() {
    }

    public User(Integer u_id, String u_name, String u_address, Date u_date, Double u_day, Integer u_money, Integer u_overtime, Integer u_tower_crane, Integer u_money_start, Integer u_address_id, Integer u_user_id) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_address = u_address;
        this.u_date = u_date;
        this.u_day = u_day;
        this.u_money = u_money;
        this.u_overtime = u_overtime;
        this.u_tower_crane = u_tower_crane;
        this.u_money_start = u_money_start;
        this.u_address_id = u_address_id;
        this.u_user_id = u_user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_address='" + u_address + '\'' +
                ", u_date=" + u_date +
                ", u_day=" + u_day +
                ", u_money=" + u_money +
                ", u_overtime=" + u_overtime +
                ", u_tower_crane=" + u_tower_crane +
                ", u_money_start=" + u_money_start +
                ", u_address_id=" + u_address_id +
                ", u_user_id=" + u_user_id +
                '}';
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public Date getU_date() {
        return u_date;
    }

    public void setU_date(Date u_date) {
        this.u_date = u_date;
    }

    public Double getU_day() {
        return u_day;
    }

    public void setU_day(Double u_day) {
        this.u_day = u_day;
    }

    public Integer getU_money() {
        return u_money;
    }

    public void setU_money(Integer u_money) {
        this.u_money = u_money;
    }

    public Integer getU_overtime() {
        return u_overtime;
    }

    public void setU_overtime(Integer u_overtime) {
        this.u_overtime = u_overtime;
    }

    public Integer getU_tower_crane() {
        return u_tower_crane;
    }

    public void setU_tower_crane(Integer u_tower_crane) {
        this.u_tower_crane = u_tower_crane;
    }

    public Integer getU_money_start() {
        return u_money_start;
    }

    public void setU_money_start(Integer u_money_start) {
        this.u_money_start = u_money_start;
    }

    public Integer getU_address_id() {
        return u_address_id;
    }

    public void setU_address_id(Integer u_address_id) {
        this.u_address_id = u_address_id;
    }

    public Integer getU_user_id() {
        return u_user_id;
    }

    public void setU_user_id(Integer u_user_id) {
        this.u_user_id = u_user_id;
    }
}
