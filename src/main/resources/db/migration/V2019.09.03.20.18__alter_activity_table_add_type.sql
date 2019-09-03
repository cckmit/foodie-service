-- 活动表增加分类
ALTER TABLE FOODIE_ACTIVITY
    add COLUMN type varchar(32) comment '活动类型' after STATUS ;

