package com.foodie.portal.city;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class CityApplicationService {

    @Autowired
    private CityRepository cityRepository;

    private Map<String, City> cities = JMockData.mock(new TypeReference<Map<String, City>>() {
    });

    public Collection<City> fetchCities() {
        return cityRepository.findAll();
    }

    public void addCity(CreateCityCommand cityCommand) {
        var city = City.create(cityCommand.getName(), cityCommand.getDesc(), cityCommand.getImages());
        cityRepository.save(city);
    }
}
