package com.rick.demo.service.Imp;

import com.rick.demo.entity.Chain;
import com.rick.demo.entity.Food;
import com.rick.demo.entity.restaurant;
import com.rick.demo.mapper.ChainMapper;
import com.rick.demo.service.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rick
 * @Date: 2020/1/2 11:24
 * @Description:
 */
@Service
public class ChainServiceImp implements ChainService {

    @Autowired
    private ChainMapper chainMapper;

    @Override
    public Collection<restaurant> getAllChain() {
        List<restaurant> list = chainMapper.getAllChain();
        Map<Integer,restaurant> map = new HashMap<>();
        for (restaurant restaurant: list) {
            map.put(restaurant.getID(),restaurant);
        }
        return map.values();
    }

    @Override
    public void insertChain(restaurant restaurant) {
        chainMapper.insertChain(restaurant);
    }

    @Override
    public restaurant getChain(Integer ID) {
        return chainMapper.getChain(ID);
    }

    @Override
    public void updateChain(restaurant restaurant) {
        chainMapper.updateChain(restaurant);
    }

    @Override
    public void deleteChain(Integer ID) {
        chainMapper.deleteChain(ID);
    }


}
