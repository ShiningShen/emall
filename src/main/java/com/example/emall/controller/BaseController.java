package com.example.emall.controller;

import com.example.emall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    ProductService productService;


    @Autowired
    CartService cartService;

    @Autowired
    DealService dealService;

    @Autowired
    UserService userService;
}
