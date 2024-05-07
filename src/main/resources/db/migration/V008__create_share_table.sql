CREATE TABLE share
(
    id        BIGINT NOT NULL,
    account_id   varchar(36) not null ,
    file_id     varchar(36) not null,
    share_name        varchar(50) not null default '',
    CONSTRAINT pk_share_entity PRIMARY KEY (id)
)