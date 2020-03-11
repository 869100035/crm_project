package com.hwua.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.RoleMapper;
import com.hwua.pojo.Role;
import com.hwua.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> findAllRoles(Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Role> roles = roleMapper.findAllRoles();
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        return pageInfo;
    }

    @Override
    public List<Role> findAllRoles() throws Exception {
        return roleMapper.findAllRoles();
    }

    @Override
    public Integer addRole(Role role) throws Exception {
        return roleMapper.addRole(role);
    }

    @Override
    public Role findRoleById(String id) throws Exception {
        return roleMapper.findRoleById(id);
    }

    @Override
    public Integer deleteRoleById(String id) throws Exception {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public Integer updateUsers_roleByUserId(String listJson, String id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        roleMapper.delUsers_roleByUserId(id);
        return roleMapper.addUsers_roleByUserId(list,id);
    }
}
