package com.rick.demo.service.Imp;

import com.rick.demo.mapper.TasteMapper;
import com.rick.demo.service.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Rick
 * @Date: 2020/1/2 16:38
 * @Description:
 */
@Service
public class TasteServiceImp implements TasteService {
    @Autowired
    private TasteMapper tasteMapper;

    @Override
    public Integer getTasteIDByName(String tasteName) {
        return tasteMapper.getTasteIDByName(tasteName);
    }
}
