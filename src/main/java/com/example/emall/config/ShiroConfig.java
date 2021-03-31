package com.example.emall.config;

import cn.hutool.core.map.MapUtil;
import com.example.emall.shiro.AccountRealm;
import com.example.emall.shiro.AuthFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Configuration
public class ShiroConfig {

    @Bean
    public SecurityManager securityManager(AccountRealm accountRealm){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);

        log.info("------------------>securityManager注入成功");

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 配置登录的url和登录成功的url
        filterFactoryBean.setLoginUrl("/login");
        // 改为首页
        filterFactoryBean.setSuccessUrl("index");
        // 配置未授权跳转页面
        filterFactoryBean.setUnauthorizedUrl("/error/403");

        filterFactoryBean.setFilters(MapUtil.of("auth", authFilter()));

        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/res/**", "anon");

        hashMap.put("/post/edit", "auth");
        hashMap.put("/post/submit", "auth");
        hashMap.put("/post/delete", "auth");

        hashMap.put("/websocket", "anon");
        hashMap.put("/login", "anon");
        filterFactoryBean.setFilterChainDefinitionMap(hashMap);

        return filterFactoryBean;

    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
