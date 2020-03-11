package com.hwua.mapper;

import com.hwua.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface RoleMapper {
    List<Role> findAllRoles()throws Exception;
    Integer addRole(Role role)throws Exception;
    Role findRoleById(String id)throws Exception;
    Integer deleteRoleById(String id)throws Exception;
    List<Role> findRolesByUserId(String id)throws Exception;
    Integer delUsers_roleByUserId(String userId)throws Exception;
    Integer addUsers_roleByUserId(@Param("list")List<String> list,@Param("id")String id)throws Exception;
}
