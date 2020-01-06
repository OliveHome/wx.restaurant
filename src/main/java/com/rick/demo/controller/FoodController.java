package com.rick.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.rick.demo.entity.Food;
import com.rick.demo.service.Imp.FoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rick
 * @Date: 2019/12/1 20:05
 * @Description: 后台管理小吃菜品
 */
@Controller
public class FoodController {

    @Autowired
    private FoodServiceImp foodServiceImp;

    /**
     * 获得所有食物信息
     * @param model
     * @return
     */
    @RequestMapping("/foods")
    public String list(Model model){
        Collection<Food> foods = foodServiceImp.getAllFood();
        model.addAttribute("foods",foods);
        return "food/list";
    }

    /**
     * 来到食物添加页面
     * @param model
     * @return
     */
    @GetMapping("/food")
    public String toAddPage(Model model) {
        return "food/add";
    }

    /**
     * 添加食物到数据库
     * @param food
     * @return
     */
    @PostMapping("/food")
    public String addFood(Food food){
        System.out.println(food);
        foodServiceImp.insertFood(food);
        return "redirect:/foods";
    }

    /**
     * 来到跳转页面
     * @param ID
     * @param model
     * @return
     */
    @GetMapping("/food/{ID}")
    public String toEditPage(@PathVariable("ID") Integer ID, Model model){
        Food food = foodServiceImp.getFood(ID);
        model.addAttribute("food",food);
        return "food/update";
    }

    /**
     * 进行食物信息的修改
     * @param food
     * @return
     */
    @PostMapping("/updatefood")
    public String updateFood(Food food){
        System.out.println(food);
        foodServiceImp.updateFood(food);
        return "redirect:/foods";
    }

    /**
     * 删除食物信息
     * @param ID
     * @return
     */
    @PostMapping("/food/{ID}")
    public String deleteFood(@PathVariable("ID") Integer ID){
        foodServiceImp.deleteFood(ID);
        return "redirect:/foods";
    }

    /**
     * 给前端返回所有食物的信息
     * @return json
     */
    @RequestMapping("/showfoods")
    @ResponseBody
    public JSONObject showFoods() {
        List<String> foodTypes = foodServiceImp.getFoodTypes();
        Map<String, Object> foodMap = foodServiceImp.getAllFoodByType(foodTypes);
        return new JSONObject(foodMap);
    }
}
