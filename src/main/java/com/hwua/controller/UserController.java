package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.User;
import com.hwua.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/user/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<User> findAllUsers(@PathVariable("pageNo") Integer pageNo,
                                       @PathVariable("pageSize") Integer pageSize)throws Exception{
        return userService.findAllUsers(pageNo, pageSize);
    }
}
