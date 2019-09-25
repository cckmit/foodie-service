package com.foodie.portal.utils;

import cn.hutool.core.util.IdUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdGenerator {

    /**
     * 毫秒格式化时间
     */
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public static String getId() {
        return IdUtil.getSnowflake(0, 0).nextIdStr();
    }

    /**
     * 格式化的毫秒时间
     */
    private static String getMillisecond() {
        return LocalDateTime.now().format(MILLISECOND);
    }

    /**
     * 时间 ID = Time + ID
     * <p>例如：可用于商品订单 ID</p>
     */
    public static String getTimeId() {
        return getMillisecond() + getId();
    }

    public static void main(String[] args) {

        System.out.println(IdGenerator.getId());
        System.out.println(IdGenerator.getTimeId());
    }

}
