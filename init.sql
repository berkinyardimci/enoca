create table company
(
    tax_id             varchar(5)   not null
        unique,
    creation_date      timestamp(6),
    id                 bigserial
        primary key,
    last_modified_date timestamp(6),
    company_name       varchar(255) not null
        unique,
    created_by         varchar(255),
    last_modified_by   varchar(255),
    type               varchar(255)
        constraint company_type_check
            check ((type)::text = ANY
        ((ARRAY ['CORPORATİON'::character varying, 'LIMITED_COMPANY'::character varying, 'ASSOCİATİON'::character varying])::text[])),
    web_site           varchar(255)
);

alter table company
    owner to postgres;

create table personnel
(
    company_id         bigint
        constraint fkdex70ttfckrk1y4it6u4u3j47
            references company,
    creation_date      timestamp(6),
    id                 bigserial
        primary key,
    last_modified_date timestamp(6),
    identity_number    varchar(11)  not null
        unique,
    created_by         varchar(255),
    first_name         varchar(255) not null,
    last_modified_by   varchar(255),
    last_name          varchar(255) not null
);

alter table personnel
    owner to postgres;

