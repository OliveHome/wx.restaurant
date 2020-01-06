package com.rick.demo.mapper;

import com.rick.demo.entity.restaurant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rick
 * @Date: 2020/1/2 11:21
 * @Description:
 */
@Mapper
@Repository
public interface ChainMapper {

    @Select(" select * from restaurant ")
    List<restaurant> getAllChain();

    @Select("select * from restaurant where ID=#{ID}")
    restaurant getChain(Integer ID);

    @Delete("delete from restaurant where ID=#{ID}")
    void deleteChain(Integer ID);

    @Insert("insert into restaurant(ID,name,addr,tel,chainID,resType)"+
    "values(#{ID},#{name},#{Addr},#{tel},#{chainID},#{resType})")
    void insertChain(restaurant restaurant);

    @Update("update restaurant set name=#{name},addr=#{Addr},tel=#{tel},chainID=#{chainID},resType=#{resType},sellinfo=#{sellinfo} where ID=#{ID}")
    void updateChain(restaurant restaurant);
}
