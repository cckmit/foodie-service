package com.foodie.portal.article;

import com.foodie.portal.activity.Activity;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@Api("文章管理")
@RestController
public class ArticleController {

    private Map<String, Article> articles = JMockData.mock(new TypeReference<Map<String, Article>>() {
    });

    @ApiOperation("文章列表")
    @GetMapping
    public Collection<Article> articles() {
        return articles.values();
    }

    @ApiOperation("发布文章")
    @PostMapping
    public Article addArticle(Article articleCommand) {
        Article article = new Article();
        articles.put(article.getId(), article);
        return article;
    }


}
