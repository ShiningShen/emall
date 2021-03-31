package com.example.emall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.common.lang.Result;
import com.example.emall.entity.Cart;
import com.example.emall.entity.Deal;
import com.example.emall.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class DealController extends BaseController {
    @RequestMapping("/deal")
    public String getOrder(){
        int pn= ServletRequestUtils.getIntParameter ( req,"pn",1);
        int size= ServletRequestUtils.getIntParameter ( req,"size",1000);
        Page page=new Page ( pn,size );
        // 分页信息
        IPage<Deal> result = dealService.paging(page);
        req.setAttribute ( "pageData",result );
        return "/user/deal";
    }

    @ResponseBody
    @PostMapping("/deal/buy")
    public Result pay(){
            List<Cart> list= cartService.list ();
            Iterator<Cart> it = list.iterator();
            HashMap<Long,Integer> productList=new HashMap<> ();

            while(it.hasNext ()){
                Cart cart=it.next ();
                Long productId=cart.getProductId ();
                if(!productList.containsKey ( productId )){
                    productList.put (productId ,1);
                }else {
                    productList.put (productId , productList.get (productId)+cart.getPostNum () );
                }
                cartService.removeById ( cart.getId () );
            }

            Set<Long> set=productList.keySet ();
            Iterator<Long> iterator = set.iterator();
            while(iterator.hasNext ()){
                Long id=iterator.next ();
                Product product = productService.getById(id);
                Assert.isTrue(product != null, "该商品已被删除");
                product.setBuyerId ( 2L );
                Integer num=productList.get ( id );
                product.setSalesCount ( product.getSalesCount()+num);
                productService.updateById ( product );
                Deal deal=new Deal ();
                deal.setPostPic ( product.getPic () );
                deal.setCreated ( new Date () );
                deal.setTitle ( product.getTitle () );
                deal.setPostNum (num);
                deal.setPrice ( product.getPrice () );
                deal.setSum ( product.getPrice () *num );
                dealService.save ( deal );
            }

        return Result.succ().action ("/deal");
    }


}
