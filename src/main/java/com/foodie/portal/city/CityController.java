package com.foodie.portal.city;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "城市管理")
@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityApplicationService cityApplicationService;

    @ApiOperation("城市列表分页")
    @GetMapping
    public Pagination<City> cities(PageCommand pageCommand) {
        return cityApplicationService.fetchCities(pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("添加城市")
    @PostMapping
    public void addCity(@RequestBody CreateCityCommand cityCommand) {
        cityApplicationService.addCity(cityCommand);
    }

    @ApiOperation("城市详情")
    @GetMapping("{id}")
    public City detail(@PathVariable String id) {
        return cityApplicationService.retrieve(id);
    }

    @ApiOperation("修改城市描述")
    @PatchMapping("{id}")
    public City updateCity(@PathVariable String id, String description) {
        return cityApplicationService.updateDescription(id, description);
    }

    @ApiOperation("删除城市")
    @DeleteMapping("{id}")
    public void deleteCity(@PathVariable String id) {
        cityApplicationService.delete(id);
    }


}
