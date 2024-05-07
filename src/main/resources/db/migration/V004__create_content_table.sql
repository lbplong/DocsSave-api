CREATE TABLE content
(
    id        varchar(36) NOT NULL,
    content   BLOB not null ,
    file_id   varchar(36) not null ,
    size       long not null,
    type        varchar(10) not null ,
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),

    CONSTRAINT pk_content_entity PRIMARY KEY (id)
)