package com.rick.demo.service.Imp;

import com.rick.demo.entity.orderTofood;
import com.rick.demo.mapper.OrderTofoodMapper;
import com.rick.demo.service.OrderToFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Rick
 * @Date: 2020/1/2 16:33
 * @Description:
 */
@Service
public class OrderToFoodServiceImp implements OrderToFoodService {

    @Autowired
    private OrderTofoodMapper orderTofoodMapper;

    @Override
    public void insertOrderToFood(orderTofood ordertofood) {
        orderTofoodMapper.insertOrderToFood(ordertofood);
    }
}
