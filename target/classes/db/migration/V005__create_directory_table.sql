CREATE TABLE directory
(
    id        varchar(36) NOT NULL,
    name  varchar(50) NOT NULL,
    level integer(1) not null default 0,
    parent_id  varchar(36) NOT NULL,
    account_id   varchar(50),
    deleted integer not null default 0,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),
    CONSTRAINT pk_directory_entity PRIMARY KEY (id)
)