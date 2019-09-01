package com.foodie.portal.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateArticleCommand {

    @ApiModelProperty("主标题")
    private String title;
    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("文章内容")
    private String content;
}
