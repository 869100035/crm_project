package com.hwua.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.PermissionMapper;
import com.hwua.pojo.Permission;
import com.hwua.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public PageInfo<Permission> findAllPermission(Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Permission> permissions = permissionMapper.findAllPermission();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        return pageInfo;
    }

    @Override
    public List<Permission> findAllPermission() throws Exception {
        return permissionMapper.findAllPermission();
    }

    @Override
    public Integer addPermission(Permission permission) throws Exception {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public Permission findPermissionById(String id) throws Exception {
        return permissionMapper.findPermissionById(id);
    }

    @Override
    public Integer deletePermissionById(String id) throws Exception {
        return permissionMapper.deletePermissionById(id);
    }

    @Override
    public Integer updateRole_PermissionByRoleId(String listJson, String id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        permissionMapper.deleteRole_PermissionByRoleId(id);
        return permissionMapper.addRole_PermissionByRoleId(list,id);
    }
}
