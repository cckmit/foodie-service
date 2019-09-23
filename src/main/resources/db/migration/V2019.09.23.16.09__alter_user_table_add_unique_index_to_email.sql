-- email增加唯一索引
create unique index inx_unq_merchant_email on FOODIE_MERCHANT(EMAIL);
create unique index inx_unq_user_email on FOODIE_USER(EMAIL);
