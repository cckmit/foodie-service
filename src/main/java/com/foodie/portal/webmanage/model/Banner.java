package com.foodie.portal.webmanage.model;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Banner {
    private String id;
    private String url;
    private String title;
    private String link;

    public Banner() {
    }

    public Banner(String title, String url, String link) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.url = url;
        this.link = link;
    }

    public static Banner create(String title, String url, String link) {
        return new Banner(title, url, link);
    }
}
