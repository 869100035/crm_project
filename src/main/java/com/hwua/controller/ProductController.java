package com.hwua.controller;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Product> findAllProducts(@PathVariable("pageNo")Integer pageNo,
                                         @PathVariable("pageSize")Integer pageSize)throws Exception{
        return productService.findAllProducts(pageNo,pageSize);
    }

    @PostMapping("/product")
    @ResponseBody
    public String addProduct(Product product)throws Exception{
        return productService.addProduct(product)+"";
    }

    @DeleteMapping("/product")
    @ResponseBody
    public Integer delectProductById(String listJson)throws Exception{
        return productService.deleteProductById(listJson);
    }

    @PutMapping("product")
    @ResponseBody
    public Integer updateProductStatus(Integer status,String listJson)throws Exception{
        return productService.updateProductStatus(status,listJson);
    }
}