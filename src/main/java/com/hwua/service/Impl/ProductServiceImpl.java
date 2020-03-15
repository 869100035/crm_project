package com.hwua.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.ProductMapper;
import com.hwua.pojo.Product;
import com.hwua.service.ILuceneProductService;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

//    @Override
//    public PageInfo<Product> findAllProducts(
//            String filedName, String term, Integer count, Integer pageNo, Integer pageSize) throws Exception {
//        PageHelper.startPage(pageNo,pageSize);
//        List<Product> products = luceneProductService.searchProductByTerm(filedName, term, count);
//        PageInfo<Product> pageInfo = new PageInfo<>(products);
//        return pageInfo;
//    }

    @Override
    public Product findProductById(String id) throws Exception {
        return productMapper.findProductById(id);
    }

    @Override
    public List<Product> findAllProducts() throws Exception {
        return productMapper.findAllProducts();
    }

    @Override
    @Transactional
    public Integer addProduct(Product product) throws Exception {
        Integer res = productMapper.addProduct(product);
//        int i=1/0;
        return res;
    }

    @Override
    public Integer deleteProductById(String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return productMapper.deleteProductById(list);
    }

    @Override
    public Integer updateProduct(Product product) throws Exception {
        return productMapper.updateProduct(product);
    }

    @Override
    public Integer updateProductStatus(Integer status, String listJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> list =  mapper.readValue(listJson,List.class);
        return productMapper.updateProductStatus(status,list);
    }
}
