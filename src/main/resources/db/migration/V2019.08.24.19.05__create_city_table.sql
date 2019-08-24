-- 角色表
DROP TABLE IF EXISTS foodie_city;
CREATE TABLE foodie_city
(
    ID          varchar(32)  NOT NULL PRIMARY KEY,
    NAME        varchar(32)  NULL,
    DESCRIPTION varchar(32)  NULL,
    images      varchar(100) NULL
);

