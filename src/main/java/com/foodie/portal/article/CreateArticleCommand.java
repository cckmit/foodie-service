package com.foodie.portal.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel
@Data
public class CreateArticleCommand {
    @ApiModelProperty("主标题")
    @NotNull(message = "标题不能为空")
    private String title;
    @ApiModelProperty("文章封面")
    private String cover;
    @ApiModelProperty("文章内容")
    private String content;
    @ApiModelProperty("城市ID")
    @NotNull
    private String cityId;
    @ApiModelProperty(value = "文章类型" , example = "FOOD")
    @NotNull
    private ArticleType type;
}

