package com.example.emall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.emall.common.lang.Result;
import com.example.emall.entity.Cart;
import com.example.emall.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController extends BaseController{
    @RequestMapping("/cart")
    public String getCart(){

        int pn= ServletRequestUtils.getIntParameter ( req,"pn",1);
        int size= ServletRequestUtils.getIntParameter ( req,"size",1000);
        Page page=new Page ( pn,size );
        // 分页信息
        IPage<Cart> result = cartService.paging(page);
        req.setAttribute ( "pageData",result );
        return "/user/cart";
    }

    @ResponseBody
    @PostMapping("/cart/buy")
    public Result buy(){
        String id = req.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            Product product = productService.getById(id);
            Assert.isTrue(product != null, "该商品已被删除");
            Integer count=0;
            if(count==0){
                Cart cart=new Cart ();
                cart.setTitle ( product.getTitle () );
                cart.setPrice ( product.getPrice () );
                cart.setPostNum ( 1 );
                cart.setProductId ( product.getId () );
                cartService.save(cart);
            }else{
                Cart cart=cartService.getOne ( new QueryWrapper<Cart> ().eq("productId", id) );
                cart.setPostNum ( cart.getPostNum ()+1 );
                cartService.updateById ( cart );
            }

        }else{
            System.out.print ( "没有id" );
        }
        return Result.succ().action ("/cart");
    }
    @ResponseBody
    @PostMapping("/cart/updateNum/{cartId}/{num}")
    public Result updateNum(@PathVariable("cartId")Long cartId,@PathVariable("num")Integer num){
        Cart cart=cartService.getById ( cartId );
        cart.setPostNum( num );
        cartService.updateById ( cart );
        return Result.succ().action ("/cart");
    }

}
