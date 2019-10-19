package com.foodie.portal.web.model;

import com.foodie.portal.city.repository.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDetailRepresentation {
    private String name;
    private String description;
    private String introduction;
    private String images;

    public static CityDetailRepresentation from(CityEntity city) {
        return new CityDetailRepresentation(city.getName(), city.getDescription(), city.getIntroduction(), city.getImages());
    }
}
