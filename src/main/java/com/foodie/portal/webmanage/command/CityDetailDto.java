package com.foodie.portal.webmanage.command;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.city.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDetailDto {
    private String name;
    private String description;
    private String images;
    private List<Activity> activities;
    private List<Article> articles;

    public static CityDetailDto toDto(City city, List<Activity> activities, List<Article> articles) {
        return CityDetailDto.builder()
                .name(city.getName())
                .description(city.getDescription())
                .images(city.getImages())
                .articles(articles)
                .activities(activities)
                .build();
    }
}
