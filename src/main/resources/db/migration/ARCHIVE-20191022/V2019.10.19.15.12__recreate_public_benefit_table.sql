-- 增加公益描述和图片字段
DROP table if exists FOODIE_PUBLIC_BENEFIT;

create table FOODIE_PUBLIC_BENEFIT
(
    ID                 VARCHAR(32)  NOT NULL COMMENT 'ID' PRIMARY KEY,
    TITLE              VARCHAR(255) NULL COMMENT '标题',
    IMAGE              VARCHAR(500) NULL COMMENT '图片',
    DESCRIPTION        TEXT         NULL COMMENT '描述',
    CONTENT            TEXT         NULL COMMENT '公益内容',
    TOTAL_FOUNDATION   DOUBLE       not null DEFAULT 0 COMMENT '总公益基金',
    CURRENT_FOUNDATION DOUBLE       not null DEFAULT 0 COMMENT '当前公益基金',
    STATUS             VARCHAR(25)  NULL COMMENT '状态',
    CREATED_AT         TIMESTAMP    NULL COMMENT '创建时间'
);
