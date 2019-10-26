package com.foodie.portal.web.model;

import com.foodie.portal.article.repository.ArticleEntity;
import lombok.Data;

@Data
public class ArticleDetailRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String cover;
    private String cityName;
    private String content;
}
