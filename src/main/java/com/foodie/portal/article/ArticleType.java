package com.foodie.portal.article;

public enum ArticleType {
    FOOD("where to eat"),
    CULTURE("culture"),
    STORY("stories/explorer");

    private String description;

    ArticleType(String description) {
        this.description = description;
    }
}
