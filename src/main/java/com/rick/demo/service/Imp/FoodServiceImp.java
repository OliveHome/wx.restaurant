package com.rick.demo.service.Imp;

import com.rick.demo.entity.Food;
import com.rick.demo.entity.FoodAndTaste;
import com.rick.demo.mapper.FoodMapper;
import com.rick.demo.mapper.TasteMapper;
import com.rick.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rick
 * @Date: 2019/12/1 19:25
 * @Description: 对食物的相关操作
 */
@Service
public class FoodServiceImp implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private TasteMapper tasteMapper;

    /**
     * 从数据库获得所有数据
     * @return Foods
     */
    @Override
    public Collection<Food> getAllFood() {

        List<Food> list = foodMapper.getAllFood();
        Map<Integer,Food> map = new HashMap<>();
        for (Food food: list) {
            map.put(food.getID(),food);
        }
        return map.values();
    }

    /**
     * 添加食物
     * @param food
     */
    @Override
    public void insertFood(Food food) {
        foodMapper.insertFood(food);
    }

    /**
     * 获取食物信息
     * @param ID
     * @return
     */
    @Override
    public Food getFood(Integer ID) {
        return foodMapper.getFood(ID);
    }

    /**
     * 修改食物信息
     * @param food
     */
    @Override
    public void updateFood(Food food) {
        foodMapper.updateFood(food);
    }

    /**
     * 删除食物信息
     * @param ID
     */
    @Override
    public void deleteFood(Integer ID) {
        foodMapper.deleteFood(ID);
    }

    @Override
    public List<String> getFoodTypes() {
        return foodMapper.getFoodTypes();
    }

    @Override
    public Map<String, Object> getAllFoodByType(List <String> foodTypes) {
        Map<String, Object> map = new HashMap<>();
        for (String foodType: foodTypes) {
            List<FoodAndTaste> foodAndTaste = foodMapper.getFoodByType(foodType);
            for(FoodAndTaste each: foodAndTaste) {
                Integer id = each.getID();
                List<String> tastes = tasteMapper.getTasteNameByFoodID(id);
                each.setTastes(tastes);
            }
            map.put(foodType, foodAndTaste);
        }
        return map;
    }
}
