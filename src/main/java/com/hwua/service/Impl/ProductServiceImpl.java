package com.hwua.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.IProductMapper;
import com.hwua.pojo.Product;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductMapper productMapper;
    @Override
    public PageInfo<Product> findAllProducts(Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> products = productMapper.findAllProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public Integer addProduct(Product product) throws Exception {
        return productMapper.addProduct(product);
    }
}
