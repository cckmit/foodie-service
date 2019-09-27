-- 文章增加城市id和创建时间
ALTER TABLE foodie_article
    add COLUMN CITY_ID varchar(32) after CONTENT;
ALTER TABLE foodie_article
    add COLUMN CREATED_AT timestamp after CITY_ID;

