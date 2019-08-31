package com.foodie.portal.article;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.TypeReference;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class ArticleApplicationService {

    MockConfig config = MockConfig.newInstance().subConfig("title").stringRegex("文章标题\\w+")
            .subConfig("content").stringRegex("文章内容\\w+").globalConfig();
    private Map<String, Article> articles = JMockData.mock(new TypeReference<Map<String, Article>>() {
    }, config);

    public Article retrieve(String id) {
        return articles.get(id);

    }

    public void addArticle(Article articleCommand) {
        var article = Article.create(articleCommand.getTitle(), articleCommand.getContent());
        articles.put(article.getId(), article);
    }

    public Article updateArticle(String id, Article articleCommand) {
        return articles.put(id, articleCommand);
    }

    public void delete(String id) {
        articles.remove(id);
    }

    public Collection<Article> articles() {
        return articles.values();
    }
}
