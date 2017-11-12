package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.ArticleDAO;
import com.baizhi.liuzz.entity.Article;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDAO articleDAO;
    @LogAnnotation(description = "添加文章")
    public void addArticle(Article article) {
        article.setId(SnowflakeIdWorker.getSnowflakeId()+"");
        article.setPubDate(new Date());
        System.out.println(article);
        articleDAO.insert(article);
    }
    //@LogAnnotation(description = "查询文章")
    public List<Article> find(String id) {
        return articleDAO.select(id);
    }
    @LogAnnotation(description = "修改文章状态")
    public void modify(String id, String state) {
        articleDAO.update(id,state);
    }
}
