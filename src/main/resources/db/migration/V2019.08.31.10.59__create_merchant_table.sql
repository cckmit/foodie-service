-- 商家表
DROP TABLE IF EXISTS foodie_merchant;
CREATE TABLE foodie_merchant
(
    ID                 varchar(32)  NOT NULL PRIMARY KEY,
    NAME               varchar(50)  NULL,
    EMAIL              varchar(100) NULL,
    CITY                varchar(100) NULL,
    DESCRIPTION        text         NULL,
    ACTIVE_DESCRIPTION text  NULL,
    IMAGES             text  NULL
);

