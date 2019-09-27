-- 角色表
DROP TABLE IF EXISTS foodie_activity;
CREATE TABLE foodie_activity
(
    ID               varchar(32)  NOT NULL PRIMARY KEY,
    TITLE            varchar(50)  NULL,
    SUB_TITLE        varchar(100) NULL,
    DESCRIPTION      text         NULL,
    CATEGORY         varchar(20)  NULL,
    DURATION         varchar(20)  NULL,
    MAX_PEOPLE_COUNT int          NULL,
    IMAGES           varchar(200) NULL,
    LANGUAGE         varchar(10)  NULL,
    ADDRESS          varchar(100) NULL,
    CITY_ID           varchar(32)  NULL,
    CITY_NAME           varchar(32)  NULL,
    PRICE_LIST        varchar(200) NULL,
    SERVICE_TIME      varchar(200) NULL,
    STATE            varchar(10)  NULL
);

