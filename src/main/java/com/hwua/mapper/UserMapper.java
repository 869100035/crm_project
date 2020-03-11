package com.hwua.mapper;

import com.hwua.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User> findAllUsers()throws Exception;
    Integer addUser(User user)throws Exception;
    User findUserById(String id)throws Exception;
    User findUserByName(String username)throws Exception;
}
