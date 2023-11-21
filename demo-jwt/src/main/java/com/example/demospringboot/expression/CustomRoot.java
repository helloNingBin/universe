package com.example.demospringboot.expression;

import com.example.demospringboot.domain.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限
 */
@Slf4j
@Component("cr")
public class CustomRoot {

    public boolean hasAuthority(String authority){

        //获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        //判断用户权限集合中是否存在authority
        log.info("自定义权限：{}",permissions);
        return permissions.contains(authority);
    }
}
