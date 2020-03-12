package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {
    PageInfo<Product> findAllProducts(Integer pageNo, Integer pageSize)throws Exception;
    List<Product> findAllProducts()throws Exception;
    Integer addProduct(Product product)throws Exception;
    Integer deleteProductById(String listJson)throws Exception;
    Integer updateProductStatus(Integer status,String listJson)throws Exception;
}
