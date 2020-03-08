package com.hwua.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.OrderMapper;
import com.hwua.pojo.Order;
import com.hwua.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public PageInfo<Order> findAllOrders(Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Order> orders = orderMapper.findAllOrders();
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }

    @Override
    public Order findOrderById(String id) throws Exception {
        return orderMapper.findOrderById(id);
    }

    @Override
    public Integer updateOrderStatus(Integer status,String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return orderMapper.updateOrderStatus(status,list);
    }

    @Override
    public Integer deleteOrdersById(String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return orderMapper.deleteOrdersById(list);
    }
}
