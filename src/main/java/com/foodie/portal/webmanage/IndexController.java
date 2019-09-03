package com.foodie.portal.webmanage;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.webmanage.command.CityDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private WebManageApplicationService webManageApplicationService;

    @GetMapping("/")
    public void index() {

    }

    @GetMapping("city-activities")
    public List<Activity> retrieveCityActivity(String cityId) {
        return webManageApplicationService.fetchRecommendCityActivities(cityId);
    }

    @GetMapping("cities/{id}")
    public CityDetailDto cityDetail(@PathVariable String id) {
        return webManageApplicationService.cityDetail(id);
    }


}
