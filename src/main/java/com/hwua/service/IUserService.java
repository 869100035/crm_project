package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    PageInfo<User> findAllUsers(Integer pageNo, Integer pageSize)throws Exception;
}
