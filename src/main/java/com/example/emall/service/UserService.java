package com.example.emall.service;

import com.example.emall.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.emall.shiro.AccountProfile;

public interface UserService extends IService<User> {

    AccountProfile login(String username, String password);
}
