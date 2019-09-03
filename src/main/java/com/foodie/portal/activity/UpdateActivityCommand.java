package com.foodie.portal.activity;

import com.foodie.portal.activity.model.ActivityDateTime;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel
public class UpdateActivityCommand {

    @ApiModelProperty("主标题")
    @NotNull
    private String title;
    @ApiModelProperty("副标题")
    private String subTitle;
    @ApiModelProperty("活动介绍")
    private String description;
    @ApiModelProperty("项目类型-餐饮")
    private String category;
    @ApiModelProperty("活动时长")
    private String duration;
    @ApiModelProperty("最大人数限制")
    private int maxPeopleLimit;
    @ApiModelProperty("活动图片")
    private String images;
    @ApiModelProperty("活动语言")
    private String language;
    @ApiModelProperty("服务地点")
    private String address;
    @ApiModelProperty("活动价格列表")
    private List<ActivityPrice> costList;
    @ApiModelProperty("活动时间")
    private List<ActivityDateTime> dates;

}