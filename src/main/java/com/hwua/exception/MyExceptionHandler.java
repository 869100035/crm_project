package com.hwua.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e, HttpServletRequest request){
        SysException se = null;
        if (e instanceof SysException){
            se = (SysException)e;
        }else {
            se = new SysException(e.getMessage());

        }
        Map<String,Object> map = new HashMap<>();
        map.put("url",request.getRequestURL());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
