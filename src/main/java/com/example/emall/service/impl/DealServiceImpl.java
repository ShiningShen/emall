package com.example.emall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Deal;
import com.example.emall.mapper.DealMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.emall.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DealServiceImpl extends ServiceImpl<DealMapper, Deal> implements DealService {

    @Autowired
    DealMapper dealMapper;

    @Override
    public IPage<Deal> paging(Page page) {
        return dealMapper.selectDeal(page);
    }
}
