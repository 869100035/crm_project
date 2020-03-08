package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderService {
    PageInfo<Order> findAllOrders(Integer pageNo, Integer pageSize)throws Exception;
    Order findOrderById(String id)throws Exception;
    Integer updateOrderStatus(Integer status,String listJson)throws Exception;
    Integer deleteOrdersById(String listJson)throws Exception;
}
