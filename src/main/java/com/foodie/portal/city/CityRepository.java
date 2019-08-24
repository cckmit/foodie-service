package com.foodie.portal.city;

import com.foodie.portal.city.repository.CityEntityMapper;
import com.foodie.portal.city.repository.CityJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class CityRepository {

    @Autowired
    private CityJpaRepository cityJpaRepository;

    public void save(City city) {
        cityJpaRepository.save(CityEntityMapper.instance.from(city));
    }


    public List<City> findAll() {
        return CityEntityMapper.instance.to(cityJpaRepository.findAll());
    }
}
