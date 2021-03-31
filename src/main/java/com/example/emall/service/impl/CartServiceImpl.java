package com.example.emall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Cart;
import com.example.emall.mapper.CartMapper;
import com.example.emall.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public IPage<Cart> paging(Page page) {
        return cartMapper.selectCart(page);
    }

}
