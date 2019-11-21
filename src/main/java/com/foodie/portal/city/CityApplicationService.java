package com.foodie.portal.city;

import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityApplicationService {

    @Autowired
    private CityRepository cityRepository;

    public Pagination<City> fetchCities(int page, int size) {
        return cityRepository.find(page - 1, size);
    }

    public void addCity(CreateCityCommand cityCommand) {
        var city = City.create(cityCommand.getName(), cityCommand.getDescription(), cityCommand.getIntroduction(), cityCommand.getImages());
        cityRepository.save(city);
    }

    public City retrieve(String id) {
        return cityRepository.findById(id);
    }

    public City updateCity(String id, UpdateCityCommand updateCityCommand) {
        var city = cityRepository.findById(id);
        city.setDescription(updateCityCommand.getDescription());
        city.setIntroduction(updateCityCommand.getIntroduction());
        city.setImages(updateCityCommand.getImages());
        // city.setShowOnActivity( updateCityCommand.getShowOnActivity()); 
        // city.setShowOnRestaurant( updateCityCommand.getShowOnRestaurant() );
        cityRepository.save(city);

        return city;
    }

    public void delete(String id) {
        cityRepository.delete(id);
    }
}
