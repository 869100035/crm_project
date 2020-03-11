package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Permission;

import java.util.List;

public interface IPermissionService {
    PageInfo<Permission> findAllPermission(Integer pageNo, Integer pageSize)throws Exception;
    List<Permission> findAllPermission()throws Exception;
    Integer addPermission(Permission permission)throws Exception;
    Permission findPermissionById(String id)throws Exception;
    Integer deletePermissionById(String id)throws Exception;
    Integer updateRole_PermissionByRoleId(String listJson,String id)throws Exception;
}
