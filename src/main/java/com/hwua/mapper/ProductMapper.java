package com.hwua.mapper;

import com.hwua.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {
    List<Product> findAllProducts()throws Exception;
    Product findProductById()throws Exception;
    Integer addProduct(Product product)throws Exception;
    Integer deleteProductById(List<String> list)throws Exception;
    Integer updateProduct(Product product)throws Exception;
    Integer updateProductStatus(@Param("status")Integer status,@Param("list")List<String> list)throws Exception;
}
