create table FOODIE_RESTAURANT_ORDER
(
    ID            VARCHAR(32) not null comment 'ID' primary key,
    NUMBER        VARCHAR(50) comment '订单号',
    RESTAURANT_ID VARCHAR(32) comment '餐厅ID',
    SET_MEAL_NAME VARCHAR(50) comment '订单名称',
    TOTAL_PRICE   DECIMAL comment '总价格',
    ITEM_PRICE    DOUBLE comment '单价',
    COUNT         INTEGER comment '下单数量',
    STATUS        VARCHAR(20) comment '订单状态',
    PAY_NO        VARCHAR(32) comment '校验码',
    CREATED_AT    TIMESTAMP comment '创建时间',
    USER_ID       VARCHAR(32) comment '用户ID',
    PAYMENT_ID    VARCHAR(100),
    ORDER_INFO    CLOB comment '下单信息',
    RESERVE_DATE  VARCHAR(50) comment '预定日期'
);

