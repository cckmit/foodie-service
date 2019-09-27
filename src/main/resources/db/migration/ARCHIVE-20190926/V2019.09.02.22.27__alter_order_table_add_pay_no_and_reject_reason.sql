-- 订单增加服务码和拒绝原因
ALTER TABLE foodie_order
    add COLUMN pay_no varchar(32) after status;
ALTER TABLE foodie_order
    add COLUMN reject_reason varchar(32) after status;
ALTER TABLE foodie_order
    add COLUMN merchant_id varchar(32) after status;
