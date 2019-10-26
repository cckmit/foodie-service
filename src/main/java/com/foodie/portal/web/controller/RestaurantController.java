package com.foodie.portal.web.controller;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.restaurant.model.RestaurantType;
import com.foodie.portal.web.model.RestaurantRepresentation;
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

    @ApiOperation("餐厅列表")
    @GetMapping("restaurants")
    public Pagination<RestaurantRepresentation> foodGuide(PageCommand pageCommand, String cityId, RestaurantType type) {
        return restaurantRepresentationService.findAllByCityAndType(pageCommand.getPage(), pageCommand.getSize(), cityId, type);
    }

    @ApiOperation("餐厅详情")
    @GetMapping("restaurants/{id}")
    public RestaurantRepresentation detail(@PathVariable String id) {
        return restaurantRepresentationService.detail(id);
    }
}
