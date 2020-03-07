package com.hwua.mapper;

import com.hwua.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderMapper {
    List<Order> findAllOrders()throws Exception;
}
