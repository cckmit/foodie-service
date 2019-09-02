package com.foodie.portal.article;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理员）文章管理")
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleApplicationService articleApplicationService;

    @ApiOperation("文章列表")
    @GetMapping
    public Pagination<Article> articles(PageCommand pageCommand) {
        return articleApplicationService.articles(pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("发布文章")
    @PostMapping
    public void addArticle(@RequestBody CreateArticleCommand articleCommand) {
        articleApplicationService.addArticle(articleCommand);
    }

    @ApiOperation("文章详情")
    @GetMapping("{id}")
    public Article detail(@PathVariable String id) {
        return articleApplicationService.retrieve(id);
    }

    @ApiOperation("修改文章")
    @PatchMapping("{id}")
    public Article updateArticle(@PathVariable String id, @RequestBody CreateArticleCommand articleCommand) {
        return articleApplicationService.updateArticle(id, articleCommand);
    }

    @ApiOperation("删除文章")
    @DeleteMapping("{id}")
    public void deleteCity(@PathVariable String id) {
        articleApplicationService.delete(id);
    }


}
