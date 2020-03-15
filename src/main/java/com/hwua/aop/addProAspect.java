package com.hwua.aop;


import com.hwua.service.ILuceneProductService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class addProAspect {

    @Autowired
    private ILuceneProductService luceneProductService;

    @Pointcut("execution(* com.hwua.controller.ProductController.addProduct(..))")
    public void addProduct(){}

    @After("addProduct()")
    public void updateLucene()throws Exception{
        luceneProductService.deleteIndex();//删除旧索引库
        luceneProductService.createIndex();//新建索引库
    }

}
