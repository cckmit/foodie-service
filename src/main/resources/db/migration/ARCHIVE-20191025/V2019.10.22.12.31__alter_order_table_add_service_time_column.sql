-- 订单表增加服务信息
alter table FOODIE_ORDER add column service_date varchar(50) comment '服务日期';
alter table FOODIE_ORDER add column start_time varchar(50) comment '服务开始时间';
