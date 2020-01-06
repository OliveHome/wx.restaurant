package com.rick.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Rick
 * @Date: 2019/12/1 19:30
 * @Description: 配置文件解决静态资源不能访问的问题
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/index.html").setViewName("login");
    }

    //    注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        静态资源  做好了静态资源的映射
        registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login",
                        "/asserts/css/**","/asserts/img/**","/asserts/js/**","/webjars/**");
    }

}
