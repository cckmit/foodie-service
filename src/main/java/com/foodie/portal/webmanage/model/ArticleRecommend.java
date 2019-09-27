package com.foodie.portal.webmanage.model;

import lombok.Data;

@Data
public class ArticleRecommend {
    private String id;
    private String title;
    private String cover;
    private String content;
    private boolean interestedRecommend;

}
