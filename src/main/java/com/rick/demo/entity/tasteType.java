package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2020/1/2 02:20
 * @Description: 口味信息
 */
public class tasteType {
    private Integer foodID;
    private Integer tasteID;
    private String tastename;

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public Integer getTasteID() {
        return tasteID;
    }

    public void setTasteID(Integer tasteID) {
        this.tasteID = tasteID;
    }

    public String getTastename() {
        return tastename;
    }

    public void setTastename(String tastename) {
        this.tastename = tastename;
    }

    @Override
    public String toString() {
        return "tasteType{" +
                "foodID=" + foodID +
                ", tasteID=" + tasteID +
                ", tastename='" + tastename + '\'' +
                '}';
    }
}
