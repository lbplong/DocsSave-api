CREATE TABLE category
(
    id        integer NOT NULL,
    account_id  varchar(36) NOT NULL,
    file_id varchar(36) not null,
    category_name  varchar(50) NOT NULL,

    CONSTRAINT pk_category_entity PRIMARY KEY (id)
)