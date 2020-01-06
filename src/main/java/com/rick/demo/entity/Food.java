package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2019/12/1 16:46
 * @Description: 食物
 */
public class Food {

    private Integer ID;
    private String name;
    private float price;
    private String foodType;
    private Integer restaurantID;
    private String imageURL;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Food{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", foodType='" + foodType + '\'' +
                ", restaurantID=" + restaurantID +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
