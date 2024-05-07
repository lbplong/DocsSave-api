CREATE TABLE account
(
    id        varchar(36) NOT NULL,
    username  varchar(50) NOT NULL,
    first_name varchar(50) not null,
    last_name  varchar(50) NOT NULL,
    account   varchar(50),
    email     varchar(200) not null,
    password  varchar(200) not null,
    check_in_time timestamp,
    status    int not null default 0,
    token     varchar(500),
    created_date timestamp not null default NOW(),
    created_by  varchar(36),
    modified_date timestamp,
    modified_by  varchar(36),
    CONSTRAINT pk_account_entity PRIMARY KEY (id)
)