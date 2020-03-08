package com.hwua.mapper;

import com.hwua.pojo.Member;
import org.springframework.stereotype.Component;

@Component
public interface MemberMapper {
    Member findMemberById(String id)throws Exception;
}
