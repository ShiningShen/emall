package com.example.emall.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CartMapper extends BaseMapper<Cart> {

    IPage<Cart> selectCart(Page page);
}
