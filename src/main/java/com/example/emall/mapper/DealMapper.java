package com.example.emall.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Deal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface DealMapper extends BaseMapper<Deal> {


    IPage<Deal> selectDeal(Page page);
}
