package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2019/12/1 16:51
 * @Description: 连锁店信息
 */
public class Chain {

    private Integer ID;
    private Integer restaurantID;
    private String name;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chain{" +
                "ID=" + ID +
                ", restaurantID=" + restaurantID +
                ", name='" + name + '\'' +
                '}';
    }
}
