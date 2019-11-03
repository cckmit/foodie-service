package com.foodie.portal.web.model;

import com.foodie.portal.article.repository.ArticleEntity;
import lombok.Data;

@Data
public class ArticleRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String cover;
    private String cityName;

    public static ArticleRepresentation from(ArticleEntity entity) {
        return ArticleRepresentationMapper.INSTANCE.from(entity);
    }
}
