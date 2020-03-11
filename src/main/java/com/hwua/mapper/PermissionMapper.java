package com.hwua.mapper;

import com.hwua.pojo.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {
    List<Permission> findAllPermission()throws Exception;
    Integer addPermission(Permission permission)throws Exception;
    Permission findPermissionById(String id)throws Exception;
    Integer deletePermissionById(String id)throws Exception;
    List<Permission> findPermissionsByRoleId(String id)throws Exception;
    Integer deleteRole_PermissionByRoleId(String id)throws Exception;
    Integer addRole_PermissionByRoleId(@Param("list") List<String> list,@Param("id") String id)throws Exception;
}
