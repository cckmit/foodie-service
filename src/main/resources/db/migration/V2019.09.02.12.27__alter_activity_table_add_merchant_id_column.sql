-- 商家登陆逻辑
ALTER TABLE foodie_activity add COLUMN  merchant_id varchar(32);

ALTER TABLE foodie_merchant add COLUMN  username varchar(64) after name;
ALTER TABLE foodie_merchant add COLUMN  password varchar(64) after name;
