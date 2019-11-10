package com.foodie.portal.web.controller;

import com.foodie.portal.web.model.CityDetailRepresentation;
import com.foodie.portal.web.service.CityRepresentationService;
import com.foodie.portal.web.model.CityRepresentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户页面接口")
@RestController
public class CityController {

    @Autowired
    private CityRepresentationService cityRepresentationService;

    @ApiOperation("所有城市")
    @GetMapping("cities")
    public List<CityRepresentation> list() {
        return cityRepresentationService.listCities();
    }

    @ApiOperation("所有活动城市")
    @GetMapping("activity-cities")
    public List<CityRepresentation> ActivityCityList() {
        return cityRepresentationService.listActivityCities();
    }

    @ApiOperation("所有城市")
    @GetMapping("restaurant-cities")
    public List<CityRepresentation> RestaurantCityList() {
        return cityRepresentationService.listRestaurantCities();
    }

    @ApiOperation("城市详情")
    @GetMapping("cities/{id}")
    public CityDetailRepresentation detail(@PathVariable String id) {
        return cityRepresentationService.detail(id);
    }
}
