package com.rick.demo.mapper;

import com.rick.demo.entity.orderTofood;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/2 01:33
 * @Description:
 */
@Mapper
@Repository
public interface OrderTofoodMapper {

    @Select("select * from orderTofood where orderID=#{ID}")
    List<orderTofood> getOrder(Integer ID);

    @Insert("insert into orderToFood(orderID,foodID,num,tasteID)"
            + "values(#{orderID},#{foodID},#{num},#{tasteID})")
    void insertOrderToFood(orderTofood ordertofood);
}
