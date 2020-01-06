package com.rick.demo.service.Imp;

import com.rick.demo.entity.*;
import com.rick.demo.mapper.FoodMapper;
import com.rick.demo.mapper.OrderTofoodMapper;
import com.rick.demo.mapper.TasteMapper;
import com.rick.demo.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Rick
 * @Date: 2020/1/2 01:42
 * @Description:
 */
@Service
public class OrderdetailServiceImp implements OrderdetailService {

    @Autowired
    private OrderTofoodMapper orderTofoodMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private TasteMapper tasteMapper;

    /**
     * 根据订单ID查所有的菜品信息
     * @param ID
     * @return
     */
    @Override
    public Collection<OrderFood> getFoods(Integer ID) {
        int i = 0;
        List<orderTofood> list = orderTofoodMapper.getOrder(ID);
        List<OrderFood> list1 = new ArrayList<>();
        System.out.println(list);
//        用来存订单foodID
        Integer [] foodsID = new Integer[list.size()];
//        存键值对方便获取tasteID和num
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (orderTofood o: list) {
            foodsID[i++] = o.getFoodID();
            map1.put(o.getFoodID(),o.getNum());
            map2.put(o.getFoodID(),o.getTasteID());
        }

//        方便注入JavaBean
        for (int j = 0; j < foodsID.length; j++) {
            OrderFood orderFood = new OrderFood();

            Food food = foodMapper.getFood(foodsID[j]);
            System.out.println(food);
            tasteType tasteType = tasteMapper.getTaste(foodsID[j],map2.get(foodsID[j]));
            System.out.println(tasteType);

            orderFood.setID(foodsID[j]);
            orderFood.setName(food.getName());
            orderFood.setNum(map1.get(foodsID[j]));
            orderFood.setTaste(tasteType.getTastename());
            orderFood.setPrice(food.getPrice());
            orderFood.setImageURL(food.getImageURL());
            list1.add(orderFood);
        }

        Map<Integer, OrderFood> map = new HashMap<>();
        for (OrderFood orderFood: list1) {
            map.put(orderFood.getID(),orderFood);
        }
        return map.values();
    }

    @Override
    public List<OrderFood> getAll(Integer ID) {
        int i = 0;
        List<orderTofood> list = orderTofoodMapper.getOrder(ID);
        List<OrderFood> list1 = new ArrayList<>();
        System.out.println(list);
//        用来存订单foodID
        Integer [] foodsID = new Integer[list.size()];
//        存键值对方便获取tasteID和num
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (orderTofood o: list) {
            foodsID[i++] = o.getFoodID();
            map1.put(o.getFoodID(),o.getNum());
            map2.put(o.getFoodID(),o.getTasteID());
        }

//        方便注入JavaBean
        for (int j = 0; j < foodsID.length; j++) {
            OrderFood orderFood = new OrderFood();

            Food food = foodMapper.getFood(foodsID[j]);
            System.out.println(food);
            tasteType tasteType = tasteMapper.getTaste(foodsID[j],map2.get(foodsID[j]));
            System.out.println(tasteType);

            orderFood.setID(foodsID[j]);
            orderFood.setName(food.getName());
            orderFood.setNum(map1.get(foodsID[j]));
            orderFood.setTaste(tasteType.getTastename());
            orderFood.setPrice(food.getPrice());
            orderFood.setImageURL(food.getImageURL());
            list1.add(orderFood);
        }
        return list1;
    }
}
