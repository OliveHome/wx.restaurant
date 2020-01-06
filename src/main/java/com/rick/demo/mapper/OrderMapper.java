package com.rick.demo.mapper;

import com.rick.demo.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/1 23:21
 * @Description:
 */
@Mapper
@Repository
public interface OrderMapper {

    @Select(" select * from `order` ")
    List<Order> getAllOrder();

    @Select("select * from `order` where ID=#{ID}")
    Order getOrder(Integer ID);

    @Select("select ID from `order` order by ID desc limit 1")
    Integer getLatestOrderID();

    @Insert("insert into `order`(price,time,description,style,status)"
            + "values(#{price},#{time},#{description},#{style},#{status})")
    void insertOrder(Order order);

    @Update("update `order` set status=#{status} where ID=#{ID}")
    void updateStatus(String status, Integer ID);
}
