package com.hwua.service;

import com.hwua.pojo.Product;

import java.util.List;

public interface ILuceneProductService {
    void createIndex()throws Exception;
    void deleteIndex()throws Exception;
    List<Product> searchProductByTerm(String filedName,String term,Integer count)throws Exception;

}
