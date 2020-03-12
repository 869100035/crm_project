package com.hwua.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

@Configuration
public class LuceneConfig {
    public static final String INDEXPATH="/Users/zhangliang/Desktop/productsDir";

    @Bean
    public Directory directory()throws Exception{
        File dir = new File(INDEXPATH);
        if (dir==null){
            dir.mkdirs();
        }
        return FSDirectory.open(dir.toPath());
    }
    @Bean
    public Analyzer analyzer()throws Exception{
        return new IKAnalyzer();
    }
}
