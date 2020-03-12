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
    private IOrderService orderService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IUserService userService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ILuceneProductService luceneProductService;
    @Test
    void contextLoads() throws Exception{
//        Integer res1 = permissionService.deleteRole_PermissionByRoleId("3e2e39a8-5e16-11ea-b047-507b9def5886");
//        System.out.println(res1);
//        User user = userService.findUserById("3a84511b-9e52-11e9-a844-484d7ebd894c");
//        List<Role> role_list = user.getList();
//        for (int i=0;i<role_list.size();i++){
//            System.out.println(i);
//            System.out.println(role_list.get(i).getList());
//        }
//        String id = "f948bbca-5eb5-11ea-a5d4-507b9def5886";
//        List<String> list = new ArrayList<>();
//        list.add("5c847a04-9e52-11e9-a844-484d7ebd894c");
//        list.add("3e2e39a8-5e16-11ea-b047-507b9def5886");
//        System.out.println(roleMapper.delUsers_roleByUserId(id));
//        System.out.println(roleMapper.addUsers_roleByUserId(list, id));
//        luceneProductService.createIndex();
//        luceneProductService.deleteIndex();
//        List<Product> products = luceneProductService.searchProductByTerm("cityName", "上海", 10);
//        System.out.println(products);
    }


}
