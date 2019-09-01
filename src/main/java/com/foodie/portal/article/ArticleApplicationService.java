package com.foodie.portal.article;

import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticleApplicationService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article retrieve(String id) {
        return articleRepository.findById(id);

    }

    public void addArticle(CreateArticleCommand articleCommand) {
        var article = Article.create(articleCommand.getTitle(), articleCommand.getCover(), articleCommand.getContent());
        articleRepository.save(article);
    }

    public Article updateArticle(String id, CreateArticleCommand articleCommand) {
        var article = articleRepository.findById(id);
        article.setContent(articleCommand.getContent());
        article.setCover(articleCommand.getCover());
        article.setTitle(articleCommand.getTitle());
        articleRepository.save(article);
        return article;
    }

    public void delete(String id) {
        articleRepository.deleteById(id);
    }

    public Pagination<Article> articles(int page, int size) {
        return articleRepository.find(page - 1, size);
    }
}
