package com.foodie.portal.webmanage;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Banner {

    private String id;
    private String url;

    private String link;

    public Banner() {
    }

    public Banner(String id, String url, String link) {
        this.id = id;
        this.url = url;
        this.link = link;
    }

    public static Banner create(String url, String link) {
        return new Banner(IdUtil.fastSimpleUUID(), url, link);
    }
}
