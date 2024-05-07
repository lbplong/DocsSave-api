CREATE TABLE share_link
(
    id        varchar(36) NOT NULL,
    name  varchar(100) NOT NULL,
    file_id varchar(36) not null,
    deleted integer(1) not null default 0,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),
    CONSTRAINT pk_share_link_entity PRIMARY KEY (id)
)