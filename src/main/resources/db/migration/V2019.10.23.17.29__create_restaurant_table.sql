DROP TABLE IF EXISTS FOODIE_RESTAURANT;
-- 创建餐厅表
CREATE TABLE IF NOT EXISTS FOODIE_RESTAURANT
(
    ID         VARCHAR(32) COMMENT 'ID' PRIMARY KEY,
    TITLE      VARCHAR(255) COMMENT '餐厅标题',
    SUB_TITLE  TEXT COMMENT '餐厅副标题',
    IMAGES     TEXT COMMENT '图片',
    CONTENT    TEXT COMMENT '餐厅内容',
    PRICE      DOUBLE COMMENT '单价',
    CITY_ID    VARCHAR(32) COMMENT '城市ID',
    CREATED_AT TIMESTAMP NULL COMMENT '创建时间'
);
