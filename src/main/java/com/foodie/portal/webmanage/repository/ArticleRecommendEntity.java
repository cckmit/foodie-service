package com.foodie.portal.webmanage.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_article")
public class ArticleRecommendEntity {
    @Id
    private String id;
    private String title;
    private String cover;
    private boolean interestedRecommend;
}
