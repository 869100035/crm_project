package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Role;
import com.hwua.pojo.User;
import com.hwua.service.IRoleService;
import com.hwua.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("/user/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<User> findAllUsers(@PathVariable("pageNo") Integer pageNo,
                                       @PathVariable("pageSize") Integer pageSize)throws Exception{
        return userService.findAllUsers(pageNo, pageSize);
    }

    @GetMapping("/userAddRole/{id}")
    public String findUserAddRole(@PathVariable("id")String id,Map<String,Object> map)throws Exception{
        User user = userService.findUserById(id);
        List<Role> user_roles = user.getList();
        List<Role> roles = roleService.findAllRoles();
        for (int i=0;i<user_roles.size();i++){
            for (int j=0;j<roles.size();j++){
                if (user_roles.get(i).getId().equals(roles.get(j).getId())){
                    roles.remove(j);
                }
            }
        }
        map.put("user_roles",user_roles);
        map.put("roles",roles);
        map.put("user",user);
        return "pages/user-role-add";
    }
    @GetMapping("/user/{id}")
    public String findUserById(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        User user = userService.findUserById(id);
        map.put("user",user);
        return "pages/user-show";
    }
    @GetMapping("/userName/{username}")
    @ResponseBody
    public Integer findUserByName(@PathVariable("username")String username)throws Exception{
        User user = userService.findUserByName(username);
        if (user!=null){
            return 1;
        }
        return 0;
    }
    @PostMapping("/user")
    @ResponseBody
    public Integer addUser(User user)throws Exception{
        return userService.addUser(user);
    }
}
