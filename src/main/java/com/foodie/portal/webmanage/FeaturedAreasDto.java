package com.foodie.portal.webmanage;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.city.City;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeaturedAreasDto {

    private City city;
    private List<Activity> activities;

    public static FeaturedAreasDto toDto(City city, List<Activity> activities) {
        return FeaturedAreasDto.builder()
                .city(city)
                .activities(activities)
                .build();
    }
}
