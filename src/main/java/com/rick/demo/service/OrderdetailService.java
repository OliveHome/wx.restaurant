package com.rick.demo.service;

import com.rick.demo.entity.OrderFood;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/2 01:39
 * @Description:
 */
public interface OrderdetailService {

    Collection<OrderFood> getFoods(Integer ID);

    List<OrderFood> getAll(Integer ID);
}
