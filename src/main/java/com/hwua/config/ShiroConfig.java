package com.hwua.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hwua.realm.UserRealm;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm userRealm(CredentialsMatcher hashedCredentialsMatcher)throws Exception{
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        return realm;
    }
    @Bean
    public SessionsSecurityManager securityManager(Realm userRealm)throws Exception{
        SessionsSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            SessionsSecurityManager securityManager)throws Exception{
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setLoginUrl("/login.html");//认证失败要跳转的页面
        Map<String ,String> shiroFilterChainMap =new LinkedHashMap<>();
        shiroFilterChainMap.put("/login","anon");
        shiroFilterChainMap.put("/logout","logout");
        shiroFilterChainMap.put("/updatePassword.html","anon");
        shiroFilterChainMap.put("/updateUserPassword","anon");
        shiroFilterChainMap.put("/css/**","anon");
        shiroFilterChainMap.put("/img/**","anon");
        shiroFilterChainMap.put("/plugins/**","anon");
        shiroFilterChainMap.put("/**","authc");
        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainMap);
        return filterFactoryBean;
    }

    @Bean
    public CredentialsMatcher hashCredentialsMatcher()throws Exception{
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
