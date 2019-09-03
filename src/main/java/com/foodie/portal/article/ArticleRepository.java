package com.foodie.portal.article;

import com.foodie.portal.article.repository.ArticleEntityMapper;
import com.foodie.portal.article.repository.ArticleJpaRepository;
import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleRepository {

    @Autowired
    private ArticleJpaRepository articleJpaRepository;

    public void save(Article article) {
        var articleEntity = ArticleEntityMapper.instance.from(article);
        articleJpaRepository.save(articleEntity);
    }

    public Pagination<Article> find(int pageIndex, int size) {
        var page = articleJpaRepository.findAll(PageRequest.of(pageIndex, size));

        return ArticleEntityMapper.instance.to(page);
    }

    public Article findById(String id) {
        return ArticleEntityMapper.instance.to(articleJpaRepository.getOne(id));
    }

    public void deleteById(String id) {
        articleJpaRepository.deleteById(id);
    }

    public List<Article> findActivitiesByIds(List<String> ids) {
        return ArticleEntityMapper.instance.to(articleJpaRepository.findByIdIn(ids));
    }

    public Pagination<Article> findByCityIdAndType(String cityId, ArticleType type, int page, int size) {
        return ArticleEntityMapper.instance.to(articleJpaRepository.findByCityIdAndType(cityId, type, PageRequest.of(page, size)));
    }
}
