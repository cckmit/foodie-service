-- 用户表
DROP TABLE IF EXISTS foodie_user;
CREATE TABLE foodie_user
(
    ID        varchar(32)  NOT NULL PRIMARY KEY,
    NAME      varchar(50)  NULL,
    EMAIL     varchar(100) NULL,
    PASSWORD  varchar(64)  null,
    CREATED_AT timestamp    NULL
);

