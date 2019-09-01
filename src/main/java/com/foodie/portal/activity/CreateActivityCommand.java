package com.foodie.portal.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class CreateActivityCommand {

    @ApiModelProperty("活动ID")
    private String id;
    @ApiModelProperty("主标题")
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
    @ApiModelProperty("服务所在城市ID")
    private String cityId;
    @ApiModelProperty("服务所在城市名称")
    private String cityName;
    @ApiModelProperty("活动价格列表")
    private List<ActivityPrice> costList;
    @ApiModelProperty("活动时间")
    private List<ActivityDateTime> dates;
    @ApiModelProperty("活动状态")
    private String state;
}
