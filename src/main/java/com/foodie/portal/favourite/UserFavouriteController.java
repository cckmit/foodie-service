package com.foodie.portal.favourite;

import com.foodie.portal.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（用户）收藏")
@RestController
@RequestMapping("user/favourite")
public class UserFavouriteController {

    @Autowired
    private FavouriteApplicationService favouriteApplicationService;

    @ApiOperation("收藏活动")
    @PostMapping("activity")
    public void favouriteActivity(String activityId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteActivity(activityId, user);
    }

    @ApiOperation("收藏餐厅")
    @PostMapping("restaurant")
    public void favouriteRestaurant(String restaurantId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteRestaurant(restaurantId, user);
    }

    @ApiOperation("收藏美食指南")
    @PostMapping("food-guide")
    public void favouriteFoodGuide(String articleId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteFoodGuide(articleId, user);
    }
}
