package com.rick.demo.mapper;

import com.rick.demo.entity.tasteType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/2 02:19
 * @Description:
 */
@Mapper
@Repository
public interface TasteMapper {

    @Select("SELECT* FROM tastetype WHERE foodID=#{foodID} AND tasteID=#{tasteID}")
    tasteType getTaste(Integer foodID, Integer tasteID);

    @Select("select tasteID from tastetype where tastename=#{tasteName}")
    Integer getTasteIDByName(String tasteName);

    @Select("select tasteName from tastetype where foodID=#{foodID}")
    List<String> getTasteNameByFoodID(Integer foodID);
}
