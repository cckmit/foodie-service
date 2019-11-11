package com.foodie.portal.favourite;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.favourite.representaion.ActivityRepresentation;
import com.foodie.portal.favourite.representaion.ArticleRepresentation;
import com.foodie.portal.favourite.representaion.FavouriteRepresentationService;
import com.foodie.portal.favourite.representaion.RestaurantRepresentation;
import com.foodie.portal.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "（用户）收藏")
@RestController
@RequestMapping("user/favourite")
public class UserFavouriteController {

    @Autowired
    private FavouriteApplicationService favouriteApplicationService;
    @Autowired
    private FavouriteRepresentationService favouriteRepresentationService;

    @ApiOperation("我的收藏活动")
    @GetMapping("activity")
    public Pagination<ActivityRepresentation> getFavouriteActivity(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return favouriteRepresentationService.findFavouriteActivityByUserId(user.getId(), command.getPage(), command.getSize());
    }

    @ApiOperation("添加收藏活动")
    @PostMapping("activity")
    public void favouriteActivity(String activityId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteActivity(activityId, user);
    }

    @ApiOperation("取消收藏活动")
    @DeleteMapping("activity")
    public void cancelFavouriteActivity(String activityId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.cancelFavouriteActivity(activityId, user);
    }

    @ApiOperation("我的收藏餐厅")
    @GetMapping("restaurant")
    public Pagination<RestaurantRepresentation> getFavouriteRestaurant(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return favouriteRepresentationService.findFavouriteRestaurantByUserId(user.getId(),command.getPage(), command.getSize());
    }

    @ApiOperation("取消收藏餐厅")
    @DeleteMapping("restaurant")
    public void cancelFavouriteRestaurant(String restaurantId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.cancelFavouriteRestaurant(restaurantId, user);
    }

    @ApiOperation("添加收藏餐厅")
    @PostMapping("restaurant")
    public void favouriteRestaurant(String restaurantId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteRestaurant(restaurantId, user);
    }

    @ApiOperation("我的收藏美食指南")
    @GetMapping("food-guide")
    public Pagination<ArticleRepresentation> getFavouriteFoodGuide(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return favouriteRepresentationService.findFavouriteFoodGuideByUserId(user.getId(), command.getPage(),command.getSize());
    }

    @ApiOperation("添加收藏美食指南")
    @PostMapping("food-guide")
    public void favouriteFoodGuide(String articleId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.favouriteFoodGuide(articleId, user);
    }

    @ApiOperation("取消收藏美食指南")
    @DeleteMapping("food-guide")
    public void cancelFavouriteFoodGuide(String foodGuideId) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        favouriteApplicationService.cancelFavouriteGoodGuide(foodGuideId, user);
    }
}
