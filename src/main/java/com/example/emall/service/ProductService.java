package com.example.emall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.emall.entity.Product;
import com.example.emall.vo.ProductVo;

public interface ProductService extends IService<Product> {

    IPage<ProductVo> paging(Page page, Long sellerId, String order);

    ProductVo selectOneProduct(QueryWrapper<Product> eq);
}
