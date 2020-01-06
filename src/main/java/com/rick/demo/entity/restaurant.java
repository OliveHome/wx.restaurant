package com.rick.demo.entity;

/**
 * @Author: Rick
 * @Date: 2019/12/1 16:57
 * @Description: 具体是哪家店的信息
 */
public class restaurant {

    private Integer ID;
    private String name;
    private float longtitude;
    private float latitude;
    private String Addr;
    private String tel;
    private Integer chainID;
    private String resType;
    private String sellinfo;

    public String getSellinfo() {
        return sellinfo;
    }

    public void setSellinfo(String sellinfo) {
        this.sellinfo = sellinfo;
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

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getChainID() {
        return chainID;
    }

    public void setChainID(Integer chainID) {
        this.chainID = chainID;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    @Override
    public String toString() {
        return "restaurant{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                ", Addr='" + Addr + '\'' +
                ", tel='" + tel + '\'' +
                ", chainID=" + chainID +
                ", resType='" + resType + '\'' +
                ", sellinfo='" + sellinfo + '\'' +
                '}';
    }
}
