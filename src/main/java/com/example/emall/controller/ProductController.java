package com.example.emall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.emall.common.lang.Result;
import com.example.emall.entity.Product;
import com.example.emall.entity.User;
import com.example.emall.vo.ProductVo;
import com.example.emall.common.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
public class ProductController extends BaseController{
    @Autowired
    UploadUtil uploadUtil;

    @GetMapping("/product/{id:\\d*}")
    public String detail(@PathVariable(name="id")Long id){
        ProductVo vo = productService.selectOneProduct (new QueryWrapper<Product>().eq("p.id", id));
        Assert.notNull(vo, "商品已被删除");
        req.setAttribute("product", vo);
        return "product/detail";
    }
    @GetMapping("/product/edit")
    public String edit(){
        String id = req.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            Product product = productService.getById(id);
            Assert.isTrue(product != null, "该商品已被删除");
//            Assert.isTrue(post.getUserId().longValue() == getProfileId().longValue(), "没权限操作此文章");
            req.setAttribute("product", product);
        }
        return "/product/edit";
    }
    @ResponseBody
    @PostMapping("/product/submit")
    public Result submit(Product product) {

        if(product.getId() == null) {
            product.setSellerId( 1L );
            User seller=userService.getById ( 1L );
            Integer num=seller.getPostCount ();
            if(num>=1000){
                return Result.fail ( "商品量超1000，请删除部分商品后继续添加" );
            }else{
                seller.setPostCount ( seller.getPostCount ()+1 );
                userService.updateById ( seller );
                product.setModified(new Date ());
                product.setCreated(new Date());

                // 校对摘要和正文字数
                if(product.getTitle ().length ()<2 ||product.getTitle ().length ()>80 ){
                    return Result.fail ( "请在规定字符范围内编辑标题" );
                }
                if(product.getPabstract ().length ()<2 ||product.getPabstract ().length ()>140 ){
                    return Result.fail ( "请在规定字符范围内编辑摘要" );
                }
                if(product.getContent ().length ()<2 ||product.getContent ().length ()>1000 ){
                    return Result.fail ( "请在规定字符范围内编辑正文" );
                }
                productService.save(product);
            }

        } else {
            Product tempProduct = productService.getById(product.getId());
            // 校对摘要和正文字数
            if(product.getTitle ().length ()<2 ||product.getTitle ().length ()>80 ){
                return Result.fail ( "请在规定字符范围内编辑标题" );
            }
            if(product.getPabstract ().length ()<2 ||product.getPabstract ().length ()>140 ){
                return Result.fail ( "请在规定字符范围内编辑摘要" );
            }
            if(product.getContent ().length ()<2 ||product.getContent ().length ()>1000 ){
                return Result.fail ( "请在规定字符范围内编辑正文" );
            }
            tempProduct.setTitle(product.getTitle());
            tempProduct.setContent(product.getContent());
            tempProduct.setPabstract (product.getPabstract ());
            tempProduct.setPic ( product.getPic () );
            productService.updateById(tempProduct);
        }


        return Result.succ("/product/" + product.getId());
    }

    @ResponseBody
    @PostMapping("/pic/upload")
    public Result uploadPic(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return uploadUtil.upload(UploadUtil.type_pic, file);
    }

}
