package com.example.emall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CartService extends IService<Cart> {

    IPage<Cart> paging(Page page);

}
