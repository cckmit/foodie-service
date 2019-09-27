-- 美食指南表增加推荐标示
alter table FOODIE_ARTICLE add column  interested_recommend tinyint(1) default 0 comment '是否设置为推荐活动';


