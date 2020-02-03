package com.foodie.portal.web.model;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class SearchRepresentation {
    private List<ActivityRepresentation> activities;
    private List<RestaurantRepresentation> restaurants;
    private List<ArticleRepresentation> articles;
}
