package com.rick.demo.service;

import com.rick.demo.entity.Food;


import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * @Author: Rick
 * @Date: 2019/12/1 19:22
 * @Description: Service层相关接口方法
 */
public interface FoodService {

    Collection<Food> getAllFood();

    void insertFood(Food food);

    Food getFood(Integer ID);

    void updateFood(Food food);

    void deleteFood(Integer ID);

    List<String> getFoodTypes();

    Map<String, Object> getAllFoodByType(List <String> foodTypes);
}
