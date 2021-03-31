package com.example.emall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Deal;
import com.baomidou.mybatisplus.extension.service.IService;

public interface DealService extends IService<Deal> {

    IPage<Deal> paging(Page page);
}
