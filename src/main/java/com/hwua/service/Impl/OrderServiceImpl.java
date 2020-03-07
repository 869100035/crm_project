package com.hwua.service.Impl;

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
}
