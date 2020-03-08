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
        Order order = orderService.findOrderById("4d1d1f65-9e51-11e9-a844-484d7ebd894c");
        System.out.println(order);
    }

}
