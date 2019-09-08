package com.foodie.portal.city.representation;

import com.foodie.portal.city.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitySummaryRepresentation {
    private String id;
    private String name;

    public static CitySummaryRepresentation toDto(City city) {
        return CitySummaryRepresentation.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
