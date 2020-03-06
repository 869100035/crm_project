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
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("pages/main");
                registry.addViewController("/header.html").setViewName("pages/header");
                registry.addViewController("/product-list1.html").setViewName("pages/product-list1");
                registry.addViewController("/orders-page-list.html").setViewName("pages/orders-page-list");
                registry.addViewController("/product-add.html").setViewName("pages/product-add");
            }
        };
    }
}
