package com.rick.demo.service.Imp;

import com.rick.demo.entity.Order;
import com.rick.demo.mapper.OrderMapper;
import com.rick.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rick
 * @Date: 2020/1/1 23:27
 * @Description:
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Collection<Order> getAllOrder() {
        List<Order> list = orderMapper.getAllOrder();
        System.out.println(list);
        Map<Integer, Order> map = new HashMap<>();
        for (Order order: list) {
            map.put(order.getID(),order);
        }
        return map.values();
    }

    @Override
    public Order getOrder(Integer ID) {
        return orderMapper.getOrder(ID);
    }

    @Override
    public Integer getLatestOrderID() {
        return orderMapper.getLatestOrderID();
    }

    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public void updateStatus(Integer ID) {
        orderMapper.updateStatus("已处理",ID);
    }
}
