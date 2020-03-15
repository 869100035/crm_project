package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.exception.SysException;
import com.hwua.pojo.Role;
import com.hwua.pojo.User;
import com.hwua.service.IRoleService;
import com.hwua.service.IUserService;
import com.hwua.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    @PostMapping("/login")
    public String login(User user,Map<String,Object> map)throws Exception{
        String info = null;
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            try {
//                token.setRememberMe(remember);
                //进行登录验证
                currentUser.login(token);
                //底层交给securityManager对象去调用注册得realm从文件或数据库中找到此登录用户的用户名和密码信息，拿到这些信息以后
                //和token中的用户名、密码进行比对。
            } catch (UnknownAccountException uae) {
                info="不存在此用户";
            } catch (IncorrectCredentialsException ice) {
                info="密码不正确";
            } catch (LockedAccountException lae) {
                info="账号锁定";
            } catch (AuthenticationException ae) {
                info="联系管理员";
            }
        }
        if(info==null){
            return "index";
        }else{
            map.put("info",info);
            return "login";
        }
    }

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

    @PostMapping("/updateUserPassword")
    @ResponseBody
    public String updatePassword(User user)throws Exception{
        User realUser = userService.findUserByName(user.getUsername());
        if (realUser==null
            ||!user.getEmail().equals(realUser.getEmail())
            ||!user.getPhoneNum().equals(realUser.getPhoneNum())){
            return "用户信息有误";
        }else {
            realUser.setPassword(MD5Util.md5hash(user.getUsername(),user.getPassword()));
            Integer res = userService.updatePassword(realUser);
            if (res==1){
                return "修改成功";
            }else {
                return "修改失败";
            }
        }
    }
}
