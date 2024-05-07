CREATE TABLE checks
(
    id        varchar(36) NOT NULL,
    name  varchar(50) NOT NULL,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),

    CONSTRAINT pk_checks_entity PRIMARY KEY (id)
)