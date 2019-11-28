package com.foodie.portal.web.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@Data
public class ArticleDetailRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String cover;
    private String cityName;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Instant createdAt;
    private boolean favourite;
}
