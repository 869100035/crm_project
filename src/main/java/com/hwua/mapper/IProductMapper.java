package com.hwua.mapper;

import com.hwua.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductMapper {
    List<Product> findAllProducts()throws Exception;
    Integer addProduct(Product product)throws Exception;
}
