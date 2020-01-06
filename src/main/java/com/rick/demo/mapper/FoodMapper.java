package com.rick.demo.mapper;

import com.rick.demo.entity.Food;
import com.rick.demo.entity.FoodAndTaste;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2019/12/1 17:01
 * @Description: 与MySQL数据之间的操作 CRUD
 */
//指定这是一个操作数据库的mapper
@Mapper
@Repository
public interface FoodMapper {

    @Select("select * from Food where ID=#{ID}")
    Food getFood(Integer ID);

    @Select("select * from Food")
    List<Food> getAllFood();

    @Delete("delete from Food where ID=#{ID}")
    void deleteFood(Integer ID);

    @Insert("insert into Food(ID,name,price,foodType,restaurantID,imageURL)" +
            "values(#{ID},#{name},#{price},#{foodType},#{restaurantID},#{imageURL})")
    void insertFood(Food food);

    @Update("update Food set name=#{name},price=#{price},foodType=#{foodType},restaurantID=#{restaurantID},imageURL=#{imageURL} where ID=#{ID}" )
    void updateFood(Food food);

    @Select("select distinct foodType from Food")
    List<String> getFoodTypes();

    @Select("select * from Food where foodType=#{foodType}")
    List<FoodAndTaste> getFoodByType(String foodType);
}
