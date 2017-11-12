package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Article;
import com.baizhi.liuzz.service.ArticleService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public class TestArticle extends BaseTest{

    @Autowired
    private ArticleService articleService;
    @Test
    public void Insert(){
        Article article =new Article(SnowflakeIdWorker.getSnowflakeId()+"","2","历史",new Date(),"dd/cc","heihei","true");
        articleService.addArticle(article);
    }
    @Test
    public void update(){
        articleService.modify("1","false");
    }
    @Test
    public void select(){
        List<Article> articles = articleService.find(null);
        for(Article a:articles){
            System.out.println(a);
        }
    }
}
