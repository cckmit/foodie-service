package com.foodie.portal.web.controller;


import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.web.model.ActivityDetailRepresentation;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.foodie.portal.web.service.ActivityRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Api(tags = "用户页面接口")
@RestController
public class ActivityController {

    @Autowired
    private ActivityRepresentationService activityRepresentationService;



    @ApiOperation("所有活动")
    @GetMapping("activities")
    public Pagination<ActivityRepresentation> activities(PageCommand pageCommand, String cityId, ActivityType type ) {
        if(Objects.isNull(type)) {
            return  activityRepresentationService.findAllByCityId(pageCommand.getPage(), pageCommand.getSize(), cityId);
        }
        return  activityRepresentationService.findAllByCityIdAndType(pageCommand.getPage(), pageCommand.getSize(), cityId, type);
    }

    @ApiOperation("活动详情")
    @GetMapping("activities/{id}")
    public ActivityDetailRepresentation detail(@PathVariable String id) {
        return activityRepresentationService.findActivityDetail(id);
    }


}
