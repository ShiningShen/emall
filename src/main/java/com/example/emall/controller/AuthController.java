package com.example.emall.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.emall.common.lang.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController extends BaseController {

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @ResponseBody
    @PostMapping({"/login","/product/login"})
    public Result doLogin( String username,String password) {
        if( StrUtil.isBlank(username)||StrUtil.isBlank(password)) {
            return Result.fail("用户名或密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username,SecureUtil.md5(password));
        try {
            SecurityUtils.getSubject().login(token);

        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                return Result.fail("用户不存在");
            } else if (e instanceof LockedAccountException) {
                return Result.fail("用户被禁用");
            } else if (e instanceof IncorrectCredentialsException) {
                return Result.fail("密码错误");
            } else {
                return Result.fail("用户认证失败");
            }
        }
        return Result.succ().action("/");
    }


    @RequestMapping({"/user/logout","/product/user/logout"})
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "/";
    }

}
