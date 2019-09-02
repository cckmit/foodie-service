-- 用户表
CREATE TABLE foodie_user
(
    ID        varchar(32)  NOT NULL PRIMARY KEY,
    NAME      varchar(50)  NULL,
    EMAIL     varchar(100) NULL,
    PASSWORD  varchar(64)  null,
    CREATE_AT timestamp    NULL
);

