package com.foodie.portal.web.controller;

import com.foodie.portal.article.ArticleType;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.web.model.ArticleDetailRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.foodie.portal.web.service.FoodGuideRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户页面接口")
@RestController
public class FoodGuideController {

    @Autowired
    private FoodGuideRepresentationService foodGuideRepresentationService;

    @ApiOperation("所有美食指南")
    @GetMapping("food-guide")
    public Pagination<ArticleRepresentation> foodGuide(PageCommand pageCommand, String cityId, ArticleType type) {
        return foodGuideRepresentationService.findAllByCityAndType(pageCommand.getPage(), pageCommand.getSize(), cityId, type);
    }

    @ApiOperation("美食指南详情")
    @GetMapping("food-guide/{id}")
    public ArticleDetailRepresentation detail(@PathVariable String id) {
        return foodGuideRepresentationService.detail(id);
    }
}
