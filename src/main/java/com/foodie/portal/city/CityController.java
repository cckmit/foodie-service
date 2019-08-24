package com.foodie.portal.city;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Api("城市管理")
@RestController
@RequestMapping("city")
public class CityController {

    private Map<String, City> cities = JMockData.mock(new TypeReference<Map<String, City>>() {
    });

    @GetMapping
    public Collection<City> cities() {
        return cities.values();
    }

    @PostMapping
    public void addCity(@RequestBody City cityCommond) {
        var city = new City();
        cities.put(city.getId(), city);
    }


}
