package com.example.emall.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.emall.entity.User;
import com.example.emall.mapper.UserMapper;
import com.example.emall.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.emall.shiro.AccountProfile;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public AccountProfile login(String username, String password) {
        User user = this.getOne(new QueryWrapper<User>().eq("username", username));
        if(user == null) {
            throw new UnknownAccountException();
        }
        System.out.print ( password );
        if(!user.getPassword().equals( password)){
            throw new IncorrectCredentialsException();
        }

        this.updateById(user);

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return profile;
    }
}
