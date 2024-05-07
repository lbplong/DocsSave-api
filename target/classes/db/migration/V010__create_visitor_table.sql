CREATE TABLE visitor
(
    id        varchar(36) NOT NULL,
    share_id varchar(36) not null,
    email   varchar(100),
    name  varchar(100) NOT NULL,
    duration BIGINT not null default 0,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),
    CONSTRAINT pk_visitor_entity PRIMARY KEY (id)
)