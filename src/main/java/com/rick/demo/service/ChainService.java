package com.rick.demo.service;

import com.rick.demo.entity.restaurant;

import java.util.Collection;

/**
 * @Author: Rick
 * @Date: 2020/1/2 11:23
 * @Description:
 */
public interface ChainService {

    Collection<restaurant> getAllChain();

    void insertChain(restaurant restaurant);

    restaurant getChain(Integer ID);

    void updateChain(restaurant restaurant);

    void deleteChain(Integer ID);
}
