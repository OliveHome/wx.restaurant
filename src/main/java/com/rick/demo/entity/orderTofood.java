package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2019/12/1 16:56
 * @Description: orderTofood中间表的信息
 */
public class orderTofood {

    private Integer orderID;
    private Integer foodID;
    private Integer num;
    private Integer tasteID;

    public Integer getTasteID() {
        return tasteID;
    }

    public void setTasteID(Integer tasteID) {
        this.tasteID = tasteID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "orderTofood{" +
                "orderID=" + orderID +
                ", foodID=" + foodID +
                ", num=" + num +
                ", tasteID=" + tasteID +
                '}';
    }
}
