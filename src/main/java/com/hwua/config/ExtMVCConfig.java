package com.hwua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExtMVCConfig {
    @Bean
    public WebMvcConfigurer extWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login.html").setViewName("login");
            registry.addViewController("/register.html").setViewName("register");
            registry.addViewController("/index.html").setViewName("index");
            registry.addViewController("/main.html").setViewName("pages/main");
            registry.addViewController("/header.html").setViewName("pages/header");
            registry.addViewController("/product-list1.html").setViewName("pages/product-list1");
            registry.addViewController("/orders-page-list.html").setViewName("pages/orders-page-list");
            registry.addViewController("/product-add.html").setViewName("pages/product-add");
            registry.addViewController("/orders-show.html").setViewName("pages/orders-show");
            registry.addViewController("/user-list.html").setViewName("pages/user-list");
            registry.addViewController("/user-add.html").setViewName("pages/user-add");
            registry.addViewController("/user-role-add.html").setViewName("pages/user-role-add");
            registry.addViewController("/role-list.html").setViewName("pages/role-list");
            registry.addViewController("/role-add.html").setViewName("pages/role-add");
            registry.addViewController("/role-show.html").setViewName("pages/role-show");
            registry.addViewController("/role-permission-add.html").setViewName("pages/role-permission-add");
            registry.addViewController("/permission-list.html").setViewName("pages/permission-list");
            registry.addViewController("/permission-add.html").setViewName("pages/permission-add");
            registry.addViewController("/permission-show.html").setViewName("pages/permission-show");


            }
        };
    }
}
