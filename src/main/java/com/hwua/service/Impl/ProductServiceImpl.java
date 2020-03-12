package com.hwua.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.ProductMapper;
import com.hwua.pojo.Product;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo<Product> findAllProducts(Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> products = productMapper.findAllProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public List<Product> findAllProducts() throws Exception {
        return productMapper.findAllProducts();
    }

    @Override
    public Integer addProduct(Product product) throws Exception {
        return productMapper.addProduct(product);
    }

    @Override
    public Integer deleteProductById(String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return productMapper.deleteProductById(list);
    }

    @Override
    public Integer updateProductStatus(Integer status, String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return productMapper.updateProductStatus(status,list);
    }
}
