package com.foodie.portal.webmanage;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleType;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
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

    @GetMapping("food-guide")
    public Pagination<Article> foodGuide(String cityId, ArticleType type , PageCommand pageCommand){
        return webManageApplicationService.foodGuide(cityId, type, pageCommand.getPage(), pageCommand.getSize());
    }

}
