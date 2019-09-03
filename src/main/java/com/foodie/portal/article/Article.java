package com.foodie.portal.article;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import lombok.Data;

import java.time.Instant;

import static java.time.Instant.now;

@Data
public class Article {

    private String id;
    private String title;
    private String cover;
    private String content;
    private City city;
    private Instant createdAt;

    public Article() {
        this.id = IdUtil.fastSimpleUUID();
        createdAt = now();
    }

    public Article(String title, String cover, String content, City city) {
        this();
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.city = city;
    }

    public static Article create(String title, String cover, String content, City city) {
        return new Article(title, cover, content, city);
    }

}
