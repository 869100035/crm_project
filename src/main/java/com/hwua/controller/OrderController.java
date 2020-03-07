package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Order;
import com.hwua.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;


    @GetMapping("/order/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Order> findAllOrders(@PathVariable("pageNo")Integer pageNo,
                                         @PathVariable("pageSize")Integer pageSize)throws Exception{
         return orderService.findAllOrders(pageNo,pageSize);
    }
}

