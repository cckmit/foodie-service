package com.foodie.portal.feedback.model;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Feedback {
    protected String id;
    protected String title;
    protected String content;

    public Feedback(String title, String content) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.content = content;
    }
}
