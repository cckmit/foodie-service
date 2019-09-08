package com.foodie.portal.city;

import com.foodie.portal.city.representation.CitySummaryRepresentation;
import com.foodie.portal.city.representation.CityRepresentationService;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（商家）城市功能")
@RestController
@RequestMapping("merchant/city")
public class MerchantCityController {

    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private CityRepresentationService cityRepresentationService;

    @ApiOperation("获取城市列表-分页")
    @GetMapping
    public Pagination<CitySummaryRepresentation> cities(PageCommand pageCommand) {
        return cityRepresentationService.listCities(pageCommand.getPage(), pageCommand.getSize());
    }

}
