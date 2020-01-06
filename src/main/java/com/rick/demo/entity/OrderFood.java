package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2020/1/2 01:26
 * @Description: 订单里面每个食物的信息
 */
public class OrderFood {

    private Integer ID;
    private String name;
    private Integer num;
    private String taste;
    private float price;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", taste='" + taste + '\'' +
                ", price=" + price +
                '}';
    }
}
