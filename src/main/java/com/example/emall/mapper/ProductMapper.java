package com.example.emall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.emall.entity.Product;
import com.example.emall.vo.ProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductVo> selectProducts(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
    ProductVo selectOneProduct(@Param(Constants.WRAPPER)QueryWrapper<Product> wrapper);
}
