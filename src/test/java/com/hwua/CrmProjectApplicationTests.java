package com.hwua;

import com.github.pagehelper.PageInfo;
import com.hwua.mapper.RoleMapper;
import com.hwua.pojo.*;
import com.hwua.service.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@MapperScan(basePackages = {"com.hwua.mapper"})
class CrmProjectApplicationTests {

    @Autowired
    private ILuceneProductService luceneProductService;
    @Test
    void contextLoads() throws Exception{
        luceneProductService.createIndex();
    }


}
