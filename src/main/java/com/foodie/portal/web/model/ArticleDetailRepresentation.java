package com.foodie.portal.web.model;

import lombok.Data;

import java.time.Instant;

@Data
public class ArticleDetailRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String cover;
    private String cityName;
    private String content;
    private Instant createdAt;
    private boolean favourite;
}
