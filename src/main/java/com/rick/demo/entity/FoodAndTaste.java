package com.rick.demo.entity;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/3 12:37
 * @Description: 返回给前端的食物信息
 */
public class FoodAndTaste {

    private Integer ID;
    private String name;
    private String foodType;
    private Integer restaurantID;
    private String imageURL;
    private float price;
    private List<String> tastes;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Integer getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<String> getTastes() {
        return tastes;
    }

    public void setTastes(List<String> tastes) {
        this.tastes = tastes;
    }

    @Override
    public String toString() {
        return "FoodAndTaste{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", foodType='" + foodType + '\'' +
                ", restaurantID=" + restaurantID +
                ", imageURL='" + imageURL + '\'' +
                ", tastes=" + tastes +
                '}';
    }
}
