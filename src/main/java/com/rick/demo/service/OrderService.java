package com.rick.demo.service;

import com.rick.demo.entity.Order;

import java.util.Collection;

/**
 * @Author: Rick
 * @Date: 2020/1/1 23:26
 * @Description:
 */
public interface OrderService {

    Collection<Order> getAllOrder();

    Order getOrder(Integer ID);

    Integer getLatestOrderID();

    void insertOrder(Order order);

    void updateStatus(Integer ID);
}
