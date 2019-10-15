-- 订单表增加支付ID
alter table FOODIE_ORDER add column  total_extract double comment '总抽成';
alter table FOODIE_ORDER add column  benefit_extract double comment '公益抽成';


