package com.rick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Rick
 * @Date: 2019/12/1 19:35
 * @Description: 欢迎界面跳转
 */

@Controller
public class HelloController {


    @RequestMapping({"/","index.html"})
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello,World!";
    }

}

