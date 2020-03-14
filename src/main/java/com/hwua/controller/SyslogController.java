package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Syslog;
import com.hwua.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SyslogController {
    @Autowired
    private ISyslogService syslogService;

    @GetMapping("/syslog/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Syslog> findAllSyslogs(
            @PathVariable("pageNo")Integer pageNo,@PathVariable("pageSize") Integer pageSize)throws Exception{
        return syslogService.findAllSyslogs(pageNo,pageSize);
    }
}
