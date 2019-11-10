package com.foodie.portal.restaurant;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.restaurant.command.CreateRestaurantCommand;
import com.foodie.portal.restaurant.command.UpdateRestaurantCommand;
import com.foodie.portal.restaurant.dto.RestaurantDto;
import com.foodie.portal.commons.utils.PaginationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理员）餐厅管理")
@RestController
@RequestMapping("admin/restaurants")
public class AdminRestaurantController {

    @Autowired
    private RestaurantApplicationService restaurantApplicationService;

    @ApiOperation("发布餐厅")
    @PostMapping
    public void createRestaurant(@RequestBody CreateRestaurantCommand command) {
        restaurantApplicationService.create(command);
    }

    @ApiOperation("餐厅详情")
    @GetMapping("{id}")
    public RestaurantDto detail(@PathVariable String id) {
        return RestaurantDto.from(restaurantApplicationService.findById(id));

    }

    @ApiOperation("餐厅列表")
    @GetMapping
    public Pagination<RestaurantDto> list(PageCommand command,String cityId) {
        return PaginationUtils.map(restaurantApplicationService.list(command.getPage(), command.getSize(), cityId),
                RestaurantDto::from);
    }

    @ApiOperation("删除餐厅")
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        restaurantApplicationService.deleteById(id);
    }

    @ApiOperation("修改餐厅")
    @PatchMapping("{id}")
    public void update(@PathVariable String id, @RequestBody UpdateRestaurantCommand command) {
        restaurantApplicationService.update(id, command);
    }

    @ApiOperation("置顶餐厅")
    @PostMapping("{id}/top")
    public void topRestaurant(@PathVariable String id) {
        restaurantApplicationService.top(id);
    }
}
