package com.hwua.aop;

import com.hwua.pojo.Syslog;
import com.hwua.pojo.User;
import com.hwua.service.ISyslogService;
import com.hwua.util.IpUtil;
import com.hwua.util.VisitTimeUtil;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAspect {

    @Autowired
    private ISyslogService syslogService;

    private String visitTime = null;
    private String userName = null;
    private String ipAddr = null;
    private String requestPath = null;
    private long startTimeMillis = 0;
    private long executionTime = 0;
    private String method = null;

    @Pointcut("execution(* com.hwua.controller.*.*(..))")
    public void controllerAspect(){}

    @Before("controllerAspect()")
    public void logBefore(){
        startTimeMillis = System.currentTimeMillis();
        visitTime = VisitTimeUtil.getNow();
    }

    @After("controllerAspect()")
    public void logAfter(JoinPoint joinPoint){
        executionTime = System.currentTimeMillis()-startTimeMillis;
    }

    @Around("controllerAspect()")
    public Object logAround(ProceedingJoinPoint pjp){
        Object res = null;
        Object[] args = pjp.getArgs();
        try {
            res = pjp.proceed(args);
            saveSyslog(pjp);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return res;
    }

    //存储日志方法
    private void saveSyslog(ProceedingJoinPoint pjp)throws Exception{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        ipAddr = IpUtil.getIpAddr(request);
        requestPath = request.getRequestURI();
        method = pjp.getSignature().getName();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user!=null){
            userName = user.getUsername();
        }
        Syslog syslog = new Syslog(null,visitTime,userName,ipAddr,
                requestPath,executionTime,method);
        syslogService.addSyslog(syslog);//存储日志信息
    }


}
