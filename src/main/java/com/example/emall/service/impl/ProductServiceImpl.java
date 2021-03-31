package com.example.emall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.emall.entity.Product;
import com.example.emall.mapper.ProductMapper;
import com.example.emall.service.ProductService;
import com.example.emall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public IPage<ProductVo> paging(Page page, Long sellerId, String order) {
        QueryWrapper wrapper=new QueryWrapper<Product> ()
                .eq ( sellerId!=null,"seller_id",sellerId);

        return productMapper.selectProducts(page,wrapper);
    }

    @Override
    public ProductVo selectOneProduct(QueryWrapper<Product> wrapper) {
        return productMapper.selectOneProduct(wrapper);
    }

}
