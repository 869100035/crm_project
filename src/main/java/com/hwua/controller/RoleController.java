package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Permission;
import com.hwua.pojo.Role;
import com.hwua.service.IPermissionService;
import com.hwua.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/role/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Role> findAllRoles(@PathVariable("pageNo")Integer pageNo,
                                   @PathVariable("pageSize")Integer pageSize)throws Exception{
        PageInfo<Role> pageInfo = roleService.findAllRoles(pageNo, pageSize);
        return pageInfo;
    }

    @GetMapping("/role/{id}")
    public String findRoleById(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        Role role = roleService.findRoleById(id);
        map.put("role",role);
        return "pages/role-show";
    }

    @PostMapping("/role")
    @ResponseBody
    public Integer addRoles(Role role)throws Exception{
        return roleService.addRole(role);
    }

    @DeleteMapping("/role")
    @ResponseBody
    public Integer deleteRoleById(String id)throws Exception{
        return roleService.deleteRoleById(id);
    }

    @GetMapping("/roleAddPer/{id}")
    public String findRoleAddPermission(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        Role role = roleService.findRoleById(id);
        List<Permission> rolePermissions = role.getList();
        List<Permission> permissions = permissionService.findAllPermission();
        for (int i=0;i<rolePermissions.size();i++){
            for (int j=0;j<permissions.size();j++){
                if (rolePermissions.get(i).getId().equals(permissions.get(j).getId())){
                    permissions.remove(j);
                }
            }
        }
        map.put("role",role);
        map.put("permissions",permissions);
        map.put("rolePermissions",rolePermissions);
        return "pages/role-permission-add";
    }

    @PutMapping("/role")
    @ResponseBody
    public Integer updateUser_RoleByUserId(String userId,String listJson)throws Exception{
        return roleService.updateUsers_roleByUserId(listJson,userId);
    }

}
