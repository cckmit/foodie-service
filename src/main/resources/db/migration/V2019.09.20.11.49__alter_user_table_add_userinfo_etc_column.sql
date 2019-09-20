-- 用户表增加用户信息
ALTER TABLE foodie_user add COLUMN LAST_NAME varchar(50) comment '姓';
ALTER TABLE foodie_user add COLUMN FIRST_NAME varchar(50) comment '名';
ALTER TABLE foodie_user add COLUMN NATIONALITY varchar(20) comment '国籍';
ALTER TABLE foodie_user add COLUMN ID_TYPE varchar(20) comment '证件类型';
ALTER TABLE foodie_user add COLUMN ID_NUMBER varchar(100) comment '证件号码';
