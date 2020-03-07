package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Order;

import java.util.List;

public interface IOrderService {
    PageInfo<Order> findAllOrders(Integer pageNo, Integer pageSize)throws Exception;
}
