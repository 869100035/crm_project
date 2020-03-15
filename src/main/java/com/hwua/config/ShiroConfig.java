package com.hwua.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hwua.realm.UserRealm;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
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
    public DefaultWebSecurityManager securityManager(Realm userRealm)throws Exception{
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setRememberMeManager(rememberMeManager());
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

    @Bean
    public SimpleCookie rememberMeCookie(){
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        //System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }
}
