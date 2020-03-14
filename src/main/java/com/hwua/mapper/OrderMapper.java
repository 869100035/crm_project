package com.hwua.mapper;

import com.hwua.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderMapper {
    List<Order> findAllOrders()throws Exception;
    List<Order> findOrdersByProductId(String productId)throws Exception;
    Order findOrderById(String id)throws Exception;
    Integer deleteOrdersById(List<String> list)throws Exception;
    Integer updateOrderStatus(@Param("status")Integer status, @Param("list")List<String> list)throws Exception;
}
