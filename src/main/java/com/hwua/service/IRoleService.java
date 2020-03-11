package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Role;

import java.util.List;

public interface IRoleService {
    PageInfo<Role> findAllRoles(Integer pageNo, Integer pageSize)throws Exception;
    List<Role> findAllRoles()throws Exception;
    Integer addRole(Role role)throws Exception;
    Role findRoleById(String id)throws Exception;
    Integer deleteRoleById(String id)throws Exception;
    Integer updateUsers_roleByUserId(String listJson,String id)throws Exception;
}
