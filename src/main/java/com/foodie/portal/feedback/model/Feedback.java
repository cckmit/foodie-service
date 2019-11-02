package com.foodie.portal.feedback.model;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class Feedback {
    protected String id;
    protected String title;
    protected String content;
    protected Instant createdAt;

    public Feedback(String title, String content) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.content = content;
        this.createdAt = Instant.now();
    }
}
