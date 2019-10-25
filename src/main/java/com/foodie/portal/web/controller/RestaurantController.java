package com.foodie.portal.web.controller;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.restaurant.Restaurant;
import com.foodie.portal.web.model.ArticleDetailRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.foodie.portal.web.model.RestaurantRepresentation;
import com.foodie.portal.web.service.FoodGuideRepresentationService;
import com.foodie.portal.web.service.RestaurantRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户页面接口")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepresentationService restaurantRepresentationService;

    @ApiOperation("所有餐厅列表")
    @GetMapping("restaurants")
    public Pagination<RestaurantRepresentation> foodGuide(PageCommand pageCommand, String cityId) {
        return restaurantRepresentationService.findAllByCity(pageCommand.getPage(), pageCommand.getSize(), cityId);
    }

    @ApiOperation("餐厅详情")
    @GetMapping("restaurants/{id}")
    public RestaurantRepresentation detail(@PathVariable String id) {
        return restaurantRepresentationService.detail(id);
    }
}
