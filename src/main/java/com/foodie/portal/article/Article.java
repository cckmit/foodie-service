package com.foodie.portal.article;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.activity.ActivityDateTime;
import com.foodie.portal.activity.ActivityPrice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class Article {

    @ApiModelProperty("文章ID")
    private String id;
    @ApiModelProperty("主标题")
    private String title;
    @ApiModelProperty("文章内容")
    private String content;

    public Article() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public Article(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }

    public static Article create(String title, String content) {
        return new Article(title, content);
    }

}
