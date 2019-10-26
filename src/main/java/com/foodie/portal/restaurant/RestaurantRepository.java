package com.foodie.portal.restaurant;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.restaurant.repository.RestaurantEntityMapper;
import com.foodie.portal.restaurant.repository.RestaurantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepository {

    public static final RestaurantEntityMapper INSTANCE = RestaurantEntityMapper.INSTANCE;
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    public void save(Restaurant restaurant) {
        restaurantJpaRepository.save(INSTANCE.from(restaurant));
    }

    public Restaurant byId(String id) {
        return restaurantJpaRepository.findById(id)
                .map(INSTANCE::to)
                .orElse(null);
    }

    public Pagination<Restaurant> findAll(int page, int size) {
        return INSTANCE.to(restaurantJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public Pagination<Restaurant> findAll(String cityId, int page, int size) {
        return INSTANCE.to(restaurantJpaRepository.findByCityId(cityId, PageRequest.of(page, size)));
    }

    public void deleteById(String id) {
        restaurantJpaRepository.deleteById(id);
    }
}

