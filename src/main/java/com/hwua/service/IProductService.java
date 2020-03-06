package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;

import java.util.List;

public interface IProductService {
    PageInfo<Product> findAllProducts(Integer pageNo, Integer pageSize)throws Exception;
    Integer addProduct(Product product)throws Exception;
}
