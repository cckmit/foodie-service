-- 公益表
DROP TABLE IF EXISTS foodie_public_benefit;
CREATE TABLE foodie_public_benefit
(
    ID                 varchar(32)  NOT NULL PRIMARY KEY,
    TITLE              varchar(255) NULL,
    CONTENT            TEXT         NULL,
    TOTAL_FOUNDATION   DECIMAL      NULL,
    CURRENT_FOUNDATION DECIMAL      null,
    CREATED_AT         timestamp    NULL
);

ALTER TABLE foodie_order
    ADD COLUMN public_benefit_id varchar(32) comment '公益ID';

