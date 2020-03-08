package com.hwua.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.UserMapper;
import com.hwua.pojo.User;
import com.hwua.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo<User> findAllUsers(Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.findAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}