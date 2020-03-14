package com.hwua.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.SyslogMapper;
import com.hwua.pojo.Syslog;
import com.hwua.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyslogServiceImpl implements ISyslogService {

    @Autowired
    private SyslogMapper syslogMapper;
    @Override
    public PageInfo<Syslog> findAllSyslogs(Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Syslog> syslogs = syslogMapper.findAllSyslogs();
        PageInfo<Syslog> pageInfo = new PageInfo<>(syslogs);
        return pageInfo;
    }

    @Override
    public Integer addSyslog(Syslog syslog) throws Exception {
        return syslogMapper.addSyslog(syslog);
    }
}
