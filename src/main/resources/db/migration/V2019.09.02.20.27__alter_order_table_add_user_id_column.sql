-- 订单增加用户外键
ALTER TABLE foodie_order
    add COLUMN user_id varchar(32);
