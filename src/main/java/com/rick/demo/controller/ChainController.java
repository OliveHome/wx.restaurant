package com.rick.demo.controller;


import com.rick.demo.entity.restaurant;
import com.rick.demo.service.Imp.ChainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Author: Rick
 * @Date: 2020/1/2 11:19
 * @Description: 连锁管理
 */
@Controller
public class ChainController {

    @Autowired
    private ChainServiceImp chainServiceImp;

    /**
     * 获得所有连锁信息
     * @param model
     * @return
     */
    @RequestMapping("/chains")
    public String getChain(Model model){
        Collection<restaurant> restaurants = chainServiceImp.getAllChain();
        model.addAttribute("restaurants",restaurants);
        return "chain/list";
    }

    /**
     * 来到食物添加页面
     * @param model
     * @return
     */
    @GetMapping("/chain")
    public String toAddPage(Model model) {
        return "chain/add";
    }

    /**
     * 添加连锁到数据库
     * @param restaurant
     * @return
     */
    @PostMapping("/chain")
    public String addChain(restaurant restaurant){
        System.out.println(restaurant);
        chainServiceImp.insertChain(restaurant);
        return "redirect:/chains";
    }

    /**
     * 来到跳转页面
     * @param ID
     * @param model
     * @return
     */
    @GetMapping("/chain/{ID}")
    public String toEditPage(@PathVariable("ID") Integer ID, Model model){
        restaurant restaurant = chainServiceImp.getChain(ID);
        model.addAttribute("restaurant",restaurant);
        return "chain/update";
    }

    /**
     * 进行连锁信息的修改
     * @param restaurant
     * @return
     */
    @PostMapping("/updatechain")
    public String updateChain(restaurant restaurant){
        System.out.println(restaurant);
        chainServiceImp.updateChain(restaurant);
        return "redirect:/chains";
    }

    /**
     * 删除连锁信息
     * @param ID
     * @return
     */
    @PostMapping("/chain/{ID}")
    public String deleteChain(@PathVariable("ID") Integer ID){
        chainServiceImp.deleteChain(ID);
        return "redirect:/chains";
    }
}
