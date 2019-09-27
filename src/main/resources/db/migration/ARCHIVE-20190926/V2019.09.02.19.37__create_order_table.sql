-- 商家表
DROP TABLE IF EXISTS foodie_order;
CREATE TABLE foodie_order
(
    ID          varchar(32) NOT NULL PRIMARY KEY,
    NUMBER      varchar(50) NULL,
    ACTIVITY_ID varchar(32) NULL,
    PRICE       DECIMAL     NULL,
    COUNT       int         null,
    STATUS      varchar(20) NULL,
    CREATED_AT   timestamp   NULL
);

