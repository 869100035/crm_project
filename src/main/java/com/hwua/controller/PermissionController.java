package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Permission;
import com.hwua.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;


    @GetMapping("/permission/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Permission> findAllPermissions(@PathVariable("pageNo")Integer pageNo,
                                                   @PathVariable("pageSize")Integer pageSize)throws Exception{
        return permissionService.findAllPermission(pageNo,pageSize);
    }

    @GetMapping("/permission/{id}")
    public String findPermissionById(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        Permission permission = permissionService.findPermissionById(id);
        map.put("permission",permission);
        return "pages/permission-show";
    }

    @PostMapping("/permission")
    @ResponseBody
    public Integer addPermission(Permission permission)throws Exception{
        return permissionService.addPermission(permission);
    }

    @DeleteMapping("/permission")
    @ResponseBody
    public Integer deletePermissionById(String id)throws Exception{
        return permissionService.deletePermissionById(id);
    }

    @PutMapping("/permission")
    @ResponseBody
    public Integer updateRolePermission(String roleId,String listJson)throws Exception{
        return permissionService.updateRole_PermissionByRoleId(listJson, roleId);
    }

}
