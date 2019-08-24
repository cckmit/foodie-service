package com.foodie.portal.activity;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class Activity {

    @ApiModelProperty("活动ID")
    private String id;
    @ApiModelProperty("主标题")
    private String title;
    @ApiModelProperty("副标题")
    private String subTitle;
    @ApiModelProperty("活动介绍")
    private String desc;
    @ApiModelProperty("项目类型-餐饮")
    private String category;
    @ApiModelProperty("活动时长")
    private String time;
    @ApiModelProperty("人数限制")
    private String limit;
    @ApiModelProperty("活动图片")
    private String images;
    @ApiModelProperty("活动语言")
    private String language;
    @ApiModelProperty("服务地点")
    private String address;
    @ApiModelProperty("服务所在城市")
    private String city;
    @ApiModelProperty("活动价格")
    private String cost;
    @ApiModelProperty("活动价格列表")
    private List<ActivityPrice> costList;
    @ApiModelProperty("活动时间")
    private List<ActivityDateTime> dates;
    @ApiModelProperty("活动状态")
    private String state;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
    }
}
