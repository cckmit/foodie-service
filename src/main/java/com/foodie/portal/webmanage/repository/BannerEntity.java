package com.foodie.portal.webmanage.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_banner")
public class BannerEntity {
    @Id
    private String id;
    private String title;
    private String url;
    private String link;
    private Instant createdAt;
}
