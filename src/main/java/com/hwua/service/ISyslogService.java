package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Syslog;

import java.util.List;

public interface ISyslogService {
    PageInfo<Syslog> findAllSyslogs(Integer pageNo,Integer pageSize)throws Exception;
    Integer addSyslog(Syslog syslog)throws Exception;
}
