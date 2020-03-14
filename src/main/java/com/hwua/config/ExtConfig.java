package com.hwua.config;

import com.hwua.util.VisitTimeUtil;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExtConfig {
    @Bean
    public ErrorAttributes errorAttributes(){
        return new MyErrorAttributes();
    }
    class MyErrorAttributes extends DefaultErrorAttributes{
        @Override
        public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
            Map<String,Object> map = new HashMap<>(super.getErrorAttributes(webRequest,includeStackTrace));
            Map<String,Object> extMap =(Map<String,Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
            map.put("timestamp", VisitTimeUtil.getNow());
            map.putAll(extMap);
            return map;
        }
    }

}
















