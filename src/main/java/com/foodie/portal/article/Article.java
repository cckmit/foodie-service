package com.foodie.portal.article;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import lombok.Data;

import java.time.Instant;
import java.util.Objects;

import static java.time.Instant.now;

@Data
public class Article {

    private String id;
    private String title;
    private String cover;
    private String content;
    private City city;
    private ArticleType type;
    private Instant createdAt;

    public Article() {
        this.id = IdUtil.fastSimpleUUID();
        createdAt = now();
    }

    public Article(String title, String cover, String content, City city, ArticleType type) {
        this();
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.city = city;
        this.type = type;
    }

    public static Article create(String title, String cover, String content, City city, ArticleType type) {
        if(Objects.isNull(city)) {
            throw new RestException(ErrorCode.FAILED, "所选城市不存在");
        }
        return new Article(title, cover, content, city, type);
    }

}
