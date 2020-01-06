package com.rick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: Rick
 * @Date: 2019/12/1 19:34
 * @Description: 登录控制
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login" , method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password
            , Map<String,Object> map , HttpSession session){

        if (!StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

}
