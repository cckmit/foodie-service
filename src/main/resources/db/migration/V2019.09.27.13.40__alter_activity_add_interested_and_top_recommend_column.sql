-- 活动表增加推荐标示
alter table FOODIE_ACTIVITY add column  interested_recommend tinyint(1) default 0 comment '是否设置为推荐活动';
alter table FOODIE_ACTIVITY add column  top_recommend tinyint(1) default 0 comment '是否设置为top推荐';


