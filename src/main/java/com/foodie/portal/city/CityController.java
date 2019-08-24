package com.foodie.portal.city;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Api(tags = "城市管理")
@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityApplicationService cityApplicationService;

    @ApiOperation("城市列表")
    @GetMapping
    public Collection<City> cities() {
        return cityApplicationService.fetchCities();
    }

    @ApiOperation("添加城市")
    @PostMapping
    public void addCity(@RequestBody CreateCityCommand cityCommand) {
        cityApplicationService.addCity(cityCommand);

    }


}
