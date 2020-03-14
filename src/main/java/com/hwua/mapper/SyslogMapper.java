package com.hwua.mapper;

import com.hwua.pojo.Syslog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SyslogMapper {
    List<Syslog> findAllSyslogs()throws Exception;
    Integer addSyslog(Syslog syslog)throws Exception;
}
