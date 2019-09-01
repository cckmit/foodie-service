package com.foodie.portal.article.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_city")
public class ArticleEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String images;
}
