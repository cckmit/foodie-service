package com.foodie.portal.article;

import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ArticleApplicationService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CityApplicationService cityApplicationService;

    public Article retrieve(String id) {
        return articleRepository.findById(id);

    }

    public void addArticle(CreateArticleCommand command) {
        var city = cityApplicationService.retrieve(command.getCityId());
        var article = Article.create(command.getTitle(), command.getCover(),
                command.getContent(), city, command.getType());
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

    public List<Article> findArticlesByIds(List<String> ids) {
        return articleRepository.findActivitiesByIds(ids);
    }

    public Pagination<Article> findArticleByCityIdAndType(String cityId, ArticleType type, int page, int size) {
        return articleRepository.findByCityIdAndType(cityId, type, page - 1, size);
    }
}
