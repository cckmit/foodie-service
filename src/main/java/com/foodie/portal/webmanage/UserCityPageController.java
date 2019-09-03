package com.foodie.portal.webmanage;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleType;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.webmanage.command.CityDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCityPageController {

    @Autowired
    private WebManageApplicationService webManageApplicationService;

    @GetMapping("cities/{id}")
    public CityDetailDto cityDetail(@PathVariable String id) {
        return webManageApplicationService.cityDetail(id);
    }

    @GetMapping("cities/{id}/activities")
    public List<Activity> cityActivities(@PathVariable String id, ActivityType type) {
        return webManageApplicationService.cityActivities(id, type);
    }

    @GetMapping("food-guide")
    public Pagination<Article> foodGuide(String cityId, ArticleType type , PageCommand pageCommand){
        return webManageApplicationService.foodGuide(cityId, type, pageCommand.getPage(), pageCommand.getSize());
    }

}
