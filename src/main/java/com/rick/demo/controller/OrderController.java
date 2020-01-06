package com.rick.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rick.demo.entity.Order;
import com.rick.demo.entity.OrderFood;
import com.rick.demo.entity.orderTofood;
import com.rick.demo.service.Imp.OrderServiceImp;
import com.rick.demo.service.Imp.OrderToFoodServiceImp;
import com.rick.demo.service.Imp.OrderdetailServiceImp;
import com.rick.demo.service.Imp.TasteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2019/12/19 20:54
 * @Description:
 */
@Controller
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;
    @Autowired
    private OrderdetailServiceImp orderdetailImp;
    @Autowired
    private TasteServiceImp tasteServiceImp;
    @Autowired
    private OrderToFoodServiceImp orderToFoodServiceImp;
    @Autowired
    private OrderdetailServiceImp orderdetailServiceImp;

    /**
     * 获得所有订单信息
     * @param model
     * @return
     */
    @RequestMapping("/orders")
    public String list(Model model){
        Collection<Order> orders = orderServiceImp.getAllOrder();
        model.addAttribute("orders",orders);
        return "order/list";
    }

    /**
     * 获得某个订单的具体信息
     * @param ID
     * @param model
     * @return
     */
    @GetMapping("/order/{ID}")
    public String get1(@PathVariable Integer ID, Model model){
        Collection<OrderFood> orderfoods = orderdetailImp.getFoods(ID);
        model.addAttribute("orderfoods",orderfoods);
        model.addAttribute("orderID",ID);
        return "order/detail";
    }

    /**
     * 完结订单,修改订单状态
     * @param ID
     * @return
     */
    @GetMapping("/orderfinish/{ID}")
    public String get2(@PathVariable Integer ID){
        orderServiceImp.updateStatus(ID);
        return "redirect:/orders";
    }

    /**
     * 接收前端传来的json格式的订单做持久化处理
     * @param obj
     * @return
     */
    @PostMapping("/sendorder")
    @ResponseBody
    public Integer addOrder(@RequestBody JSONObject obj) {
        JSONArray goodslist = obj.getJSONArray("goodsList");

        float price = obj.getFloatValue("totalPrice");
        String description = obj.getString("description");
        String style = obj.getString("style");
        String time = obj.getString("time");
        Order order = new Order();
        order.setPrice(price);
        order.setDescription(description);
        order.setStyle(style);
        order.setTime(time);
        order.setStatus("待处理");
        orderServiceImp.insertOrder(order);

        Integer orderid = orderServiceImp.getLatestOrderID();
        for(int i = 0; i < goodslist.size(); i++) {
            JSONObject goods = goodslist.getJSONObject(i);
            Integer foodid = goods.getInteger("ID");
            Integer num = goods.getInteger("num");
            String taste = goods.getString("taste");
            Integer tasteID = tasteServiceImp.getTasteIDByName(taste);
            orderTofood ordertofood = new orderTofood();
            ordertofood.setOrderID(orderid);
            ordertofood.setFoodID(foodid);
            ordertofood.setNum(num);
            ordertofood.setTasteID(tasteID);
            orderToFoodServiceImp.insertOrderToFood(ordertofood);
        }
        return orderid;
    }

    /**
     * 发送给前端用户的信息
     * @return
     */
    @RequestMapping("/getorders")
    @ResponseBody
    public JSONObject sendOrder(){
        Collection<Order> orders = orderServiceImp.getAllOrder();
        JSONArray jsonArray = new JSONArray();

        for (Order order:orders) {
            jsonArray.add(order);
        }
        JSONObject object = new JSONObject();
        object.put("allorders",jsonArray);
        return object;
    }

    /**
     * 根据订单向用户展示具体订单信息
     * @param ID
     * @return json
     */
    @RequestMapping("/getorderfoods")
    @ResponseBody
    public JSONObject responseDetail(@RequestParam Integer ID){
        JSONObject object = new JSONObject();
        Order order = orderServiceImp.getOrder(ID);
        LocalDateTime time = LocalDateTime.now();
        List<OrderFood> list = orderdetailServiceImp.getAll(ID);

        JSONArray jsonArray = new JSONArray();

        for (OrderFood item: list) {
            jsonArray.add(item);
        }

        object.put("orderID",order.getID());
        object.put("goodsList",jsonArray);
        object.put("decription",order.getDescription());
        object.put("status",order.getStatus());
        object.put("orderTime",time);
        object.put("repastTime",order.getTime());
        object.put("repastStyle",order.getStyle());

        return object;
    }
}
