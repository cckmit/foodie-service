package com.foodie.portal.web.city;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
