CREATE TABLE role_account_share
(
    id        BIGINT NOT NULL,
    username  varchar(50) NOT NULL,
    account_id   varchar(36) not null ,
    share_id     varchar(36) not null,
    role        varchar(50) not null default 'viewer',
    CONSTRAINT pk_role_account_share_entity PRIMARY KEY (id)
)