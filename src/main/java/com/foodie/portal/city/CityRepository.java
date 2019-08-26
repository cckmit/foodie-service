package com.foodie.portal.city;

import com.foodie.portal.city.repository.CityEntityMapper;
import com.foodie.portal.city.repository.CityJpaRepository;
import com.foodie.portal.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityRepository {

    @Autowired
    private CityJpaRepository cityJpaRepository;

    public void save(City city) {
        cityJpaRepository.save(CityEntityMapper.instance.from(city));
    }


    public Pagination<City> find(int page, int size) {
        return CityEntityMapper.instance.to(cityJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public City findById(String id) {
        return CityEntityMapper.instance.to(cityJpaRepository.getOne(id));
    }

    public void delete(String id) {
        cityJpaRepository.deleteById(id);
    }
}
