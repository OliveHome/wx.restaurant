package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2019/12/1 16:52
 * @Description: 管理员信息
 */
public class host {

    private String account;
    private String password;
    private Integer restaurantID;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    @Override
    public String toString() {
        return "host{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", restaurantID=" + restaurantID +
                '}';
    }
}
