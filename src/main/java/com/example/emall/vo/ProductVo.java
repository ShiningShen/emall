package com.example.emall.vo;

import com.example.emall.entity.Product;
import lombok.Data;

@Data
public class ProductVo extends Product {
    private String sellerName;
    private String sold;

}
