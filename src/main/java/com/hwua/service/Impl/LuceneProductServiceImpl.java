package com.hwua.service.Impl;

import com.hwua.config.LuceneConfig;
import com.hwua.pojo.Product;
import com.hwua.service.ILuceneProductService;
import com.hwua.service.IProductService;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
@Service
public class LuceneProductServiceImpl implements ILuceneProductService {

    @Autowired
    private IProductService productService;

    @Override
    public void createIndex() throws Exception {
        List<Product> products = productService.findAllProducts();
        Directory directory = FSDirectory.open(new File(LuceneConfig.INDEXPATH).toPath());
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
        for (Product product:products){
            Document document = new Document();
            document.add(new StringField("id",product.getId(), Field.Store.YES));
            document.add(new StringField("productNum",product.getProductNum(), Field.Store.YES));
            document.add(new TextField("productName",product.getProductName(), Field.Store.YES));
            document.add(new TextField("cityName",product.getCityName(), Field.Store.YES));
            document.add(new TextField("departureTime",product.getDepartureTime(), Field.Store.YES));
            document.add(new TextField("productPrice",product.getProductPrice()+"", Field.Store.YES));
            document.add(new TextField("productDesc",product.getProductDesc(), Field.Store.YES));
            document.add(new StringField("productStatus",product.getProductStatus()+"", Field.Store.YES));
            indexWriter.addDocument(document);
        }
        indexWriter.commit();
        indexWriter.close();
    }

    @Override
    public void deleteIndex() throws Exception {
        Directory directory = FSDirectory.open(new File(LuceneConfig.INDEXPATH).toPath());
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
        indexWriter.deleteAll();
        indexWriter.commit();
        indexWriter.close();
    }

    @Override
    public List<Product> searchProductByTerm(String filedName, String term, Integer count) throws Exception {
        List<Product> list = new ArrayList<>();
        Directory directory = FSDirectory.open(new File(LuceneConfig.INDEXPATH).toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        TermQuery query = new TermQuery(new Term(filedName, term));
        TopDocs topDocs = indexSearcher.search(query, count);
        for (ScoreDoc scoreDoc:topDocs.scoreDocs){
            int docId = scoreDoc.doc;
            Document document = indexSearcher.doc(docId);
            Product product = new Product();
            product.setId(document.get("id"));
            product.setProductNum(document.get("productNum"));
            product.setProductName(document.get("productName"));
            product.setCityName(document.get("cityName"));
            product.setDepartureTime(document.get("departureTime"));
            product.setProductPrice(Double.parseDouble(document.get("productPrice")));
            product.setProductDesc(document.get("productDesc"));
            product.setProductStatus(Integer.parseInt(document.get("productStatus")));
            list.add(product);
        }
        indexReader.close();
        return list;
    }
}




















