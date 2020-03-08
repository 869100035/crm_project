package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Order;
import com.hwua.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        Order order = orderService.findOrderById(id);
        map.put("order",order);
        System.out.println(order);
        return "/pages/orders-show";
    }
    @PutMapping("/order")
    @ResponseBody
    public Integer updateOrderStatus(Integer status,String listJson)throws Exception{
        return orderService.updateOrderStatus(status,listJson);
    }

    @DeleteMapping("/order")
    @ResponseBody
    public Integer deleteOrdersById(String listJson)throws Exception{
        return orderService.deleteOrdersById(listJson);
    }
}

