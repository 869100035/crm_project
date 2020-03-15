package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import com.hwua.service.ILuceneProductService;
import com.hwua.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ILuceneProductService luceneProductService;

    @GetMapping("/product/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Product> findAllProducts(@PathVariable("pageNo")Integer pageNo,
                                         @PathVariable("pageSize")Integer pageSize)throws Exception{
        return productService.findAllProducts(pageNo,pageSize);
    }

    @GetMapping("/product/{id}")
    public String findProductByIdToUpdate(@PathVariable("id")String id, Map<String,Object> map)throws Exception{
        Product product = productService.findProductById(id);
        map.put("product",product);
        return "pages/product-update";
    }
    @PostMapping("/product")
    @ResponseBody
    public String addProduct(Product product)throws Exception{
        return productService.addProduct(product)+"";
    }

    @DeleteMapping("/product")
    @ResponseBody
    public Integer delectProductById(String listJson)throws Exception{
        return productService.deleteProductById(listJson);
    }

    @PutMapping("/product")
    @ResponseBody
    public Integer updateProductStatus(Integer status,String listJson)throws Exception{
        return productService.updateProductStatus(status,listJson);
    }
    @PostMapping("/productProperties")
    @ResponseBody
    public Integer updateProduct(Product product)throws Exception{
        System.out.println(product);
        return productService.updateProduct(product);
    }


    @GetMapping("/find_step1/{fieldName}/{term}")
    public String addFieldNameAndTerm(@PathVariable("fieldName")String fieldName,
                                      @PathVariable("term")String term,HttpSession session)throws Exception{
        session.setAttribute("fieldName",fieldName);
        session.setAttribute("term",term);
        return "pages/product-list-search";
    }

    @GetMapping("/find_step2/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Product> findProductsByTerm(@PathVariable("pageNo")Integer pageNo,
                                                @PathVariable("pageSize")Integer pageSize,HttpSession session)throws Exception{
        String fieldName = (String) session.getAttribute("fieldName");
        String term = (String) session.getAttribute("term");
        PageHelper.startPage(pageNo,pageSize);
        List<Product> products = luceneProductService.searchProductByTerm(fieldName, term, 10);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }
}
