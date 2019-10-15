-- 增加公益描述和图片字段
ALTER TABLE FOODIE_PUBLIC_BENEFIT add column IMAGE varchar(255) comment '公益图片';
ALTER TABLE FOODIE_PUBLIC_BENEFIT add column DESCRIPTION TEXT comment '公益描述';
