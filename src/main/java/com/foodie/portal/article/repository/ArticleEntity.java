package com.foodie.portal.article.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_article")
public class ArticleEntity {
    @Id
    private String id;
    private String title;
    private String cover;
    private String content;
}
