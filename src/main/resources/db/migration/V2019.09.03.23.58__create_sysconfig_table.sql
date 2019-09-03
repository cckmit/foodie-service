-- 用户表
DROP TABLE IF EXISTS foodie_sysconfig;
CREATE TABLE foodie_sysconfig
(
    CONFIG_KEY   varchar(100) NOT NULL PRIMARY KEY,
    CONFIG_VALUE text         NULL,
    DESCRIPTION  varchar(100) NULL
);

