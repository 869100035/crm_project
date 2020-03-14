package com.hwua.service;

import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {
    PageInfo<Product> findAllProducts(Integer pageNo, Integer pageSize)throws Exception;
    PageInfo<Product> findAllProducts(String filedName, String term, Integer count,
                                      Integer pageNo, Integer pageSize)throws Exception;
    Product findProductById(String id)throws Exception;
    List<Product> findAllProducts()throws Exception;
    Integer addProduct(Product product)throws Exception;
    Integer deleteProductById(String listJson)throws Exception;
    Integer updateProduct(Product product)throws Exception;
    Integer updateProductStatus(Integer status,String listJson)throws Exception;
}
