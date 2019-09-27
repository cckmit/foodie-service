-- 文章增加分类
ALTER TABLE foodie_article
    add COLUMN type varchar(32) comment '文章类型' after CONTENT;

