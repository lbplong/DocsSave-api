CREATE TABLE file
(
    id        varchar(36) NOT NULL,
    name  varchar(255) NOT NULL,
    display_name varchar(255) not null,
    size  long NOT NULL,
    account_id   varchar(36),
    directory_id     varchar(36),
    type  varchar(10) not null,
    deleted integer not null default 0,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),
    CONSTRAINT pk_file_entity PRIMARY KEY (id)
)