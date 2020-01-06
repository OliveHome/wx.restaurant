package com.rick.demo.entity;


/**
 * @Author: Rick
 * @Date: 2019/12/1 16:53
 * @Description: 订单信息
 */
public class Order {

    private Integer ID;
    private float price;
    private String time;
    private String description;
    private String style;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", price=" + price +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", style='" + style + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
