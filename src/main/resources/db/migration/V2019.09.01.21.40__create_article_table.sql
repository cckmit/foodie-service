-- 文章表
DROP TABLE IF EXISTS foodie_article;
CREATE TABLE foodie_article
(
    ID      varchar(32) NOT NULL PRIMARY KEY,
    TITLE   varchar(100) NULL,
    COVER   varchar(100) NULL,
    CONTENT text        NULL
);
