package com.daiban.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: daiban
 * @description: 计算各个用户总数据
 * @author: 施
 * @create: 2019-11-08 11:10
 **/

public class UserClass {

    private String u_name;//用户姓名
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM")
    private Date u_date;//带班月份
    private Double acount_day;//带班总天数
    private Integer acount_overtime;//加班时长
    private Integer acount_money;//总金额
    private Integer acount_money_start;//已付款
    private Integer userNon_Payment;//未付款

    public UserClass() {
    }

    public UserClass(String u_name, Date u_date, Double acount_day, Integer acount_overtime, Integer acount_money, Integer acount_money_start, Integer userNon_Payment) {
        this.u_name = u_name;
        this.u_date = u_date;
        this.acount_day = acount_day;
        this.acount_overtime = acount_overtime;
        this.acount_money = acount_money;
        this.acount_money_start = acount_money_start;
        this.userNon_Payment = userNon_Payment;
    }

    @Override
    public String toString() {
        return "UserClass{" +
                "u_name='" + u_name + '\'' +
                ", u_date=" + u_date +
                ", acount_day=" + acount_day +
                ", acount_overtime=" + acount_overtime +
                ", acount_money=" + acount_money +
                ", acount_money_start=" + acount_money_start +
                ", userNon_Payment=" + userNon_Payment +
                '}';
    }

    public String getu_name() {
        return u_name;
    }

    public void setu_name(String u_name) {
        this.u_name = u_name;
    }

    public Date getu_date() {
        return u_date;
    }

    public void setu_date(Date u_date) {
        this.u_date = u_date;
    }

    public Double getAcount_day() {
        return acount_day;
    }

    public void setAcount_day(Double acount_day) {
        this.acount_day = acount_day;
    }

    public Integer getAcount_overtime() {
        return acount_overtime;
    }

    public void setAcount_overtime(Integer acount_overtime) {
        this.acount_overtime = acount_overtime;
    }

    public Integer getAcount_money() {
        return acount_money;
    }

    public void setAcount_money(Integer acount_money) {
        this.acount_money = acount_money;
    }

    public Integer getAcount_money_start() {
        return acount_money_start;
    }

    public void setAcount_money_start(Integer acount_money_start) {
        this.acount_money_start = acount_money_start;
    }

    public Integer getUserNon_Payment() {
        return userNon_Payment;
    }

    public void setUserNon_Payment(Integer userNon_Payment) {
        this.userNon_Payment = userNon_Payment;
    }
}
