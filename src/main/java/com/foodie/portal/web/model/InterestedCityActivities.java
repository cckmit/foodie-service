package com.foodie.portal.web.model;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class InterestedCityActivities {
    private String cityName;
    private String cityIntroduction;
    private String cityImages;
    List<ActivityRepresentation> activities;
}
