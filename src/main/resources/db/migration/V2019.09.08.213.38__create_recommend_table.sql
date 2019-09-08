-- 推荐表
DROP TABLE IF EXISTS foodie_recommend;
CREATE TABLE foodie_recommend
(
    id   varchar(100) NOT NULL,
    type varchar(30)  not NULL,
    primary key (id, type)
);

