package com.foodie.portal.article;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Article {

    private String id;
    private String title;
    private String cover;
    private String content;

    public Article() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public Article(String title, String cover, String content) {
        this();
        this.title = title;
        this.cover = cover;
        this.content = content;
    }

    public static Article create(String title, String cover, String content) {
        return new Article(title, cover, content);
    }

}
