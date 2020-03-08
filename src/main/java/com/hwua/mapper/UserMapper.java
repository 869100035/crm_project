package com.hwua.mapper;

import com.hwua.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User> findAllUsers()throws Exception;
}
