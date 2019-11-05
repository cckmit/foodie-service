package com.foodie.portal.webmanage.model;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.time.Instant;

@Data
public class Banner {
    private String id;
    private String url;
    private String title;
    private String subTitle;
    private String link;
    private Instant createdAt;

    public Banner() {
        createdAt = Instant.now();
    }

    public Banner(String title, String subTitle, String url, String link) {
        this.id = IdUtil.fastSimpleUUID();
        this.subTitle = subTitle;
        this.title = title;
        this.url = url;
        this.link = link;
    }

    public static Banner create(String title, String subTitle, String url, String link) {
        return new Banner(title, subTitle, url, link);
    }
}
