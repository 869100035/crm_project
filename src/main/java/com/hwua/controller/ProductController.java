package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/findAllProducts/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Product> findAllProducts(@PathVariable("pageNo")Integer pageNo,
                                         @PathVariable("pageSize")Integer pageSize)throws Exception{
        return productService.findAllProducts(pageNo,pageSize);
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public String addProduct(Product product)throws Exception{
        return productService.addProduct(product)+"";
    }
}
