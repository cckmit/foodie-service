-- banner图表
CREATE TABLE if not exists foodie_banner
(
    ID         VARCHAR(32)  NOT NULL PRIMARY KEY,
    TITLE      VARCHAR(255) NULL,
    URL        VARCHAR(100) NOT NULL,
    LINK       VARCHAR(100) NULL,
    CREATED_AT TIMESTAMP    NULL
);

