package com.hwua;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Order;
import com.hwua.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = {"com.hwua.mapper"})
class CrmProjectApplicationTests {

    @Autowired
    private IOrderService orderService;
    @Test
    void contextLoads() throws Exception{
        PageInfo<Order> pageInfo = orderService.findAllOrders(1, 3);
        System.out.println(pageInfo);
    }

}
