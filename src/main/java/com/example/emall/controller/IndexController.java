package com.example.emall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.entity.Product;
import com.example.emall.vo.ProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

    @RequestMapping({"","/","index"})
    public String index(){
        int pn= ServletRequestUtils.getIntParameter ( req,"pn",1);
        int size= ServletRequestUtils.getIntParameter ( req,"size",3);
        Page page=new Page ( pn,size );
        // 分页信息，用户，排序，是否售出[这里不要出现post中的字段]
        IPage<ProductVo> result = productService.paging(page,null,"created");
        req.setAttribute ( "pageData",result );
        return "index";
    }
}
