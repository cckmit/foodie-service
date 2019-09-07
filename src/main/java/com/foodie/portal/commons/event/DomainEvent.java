package com.foodie.portal.commons.event;

import cn.hutool.core.util.IdUtil;
import lombok.Getter;

import java.time.Instant;

import static java.time.Instant.now;

@Getter
public abstract class DomainEvent {
    private String id = IdUtil.fastSimpleUUID();
    private Instant createdAt = now();
}
