package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    PageInfo<User> findAllUsers(Integer pageNo, Integer pageSize)throws Exception;
    Integer addUser(User user)throws Exception;
    User findUserById(String id)throws Exception;
    User findUserByName(String username)throws Exception;
    Integer updatePassword(User user)throws Exception;
}
