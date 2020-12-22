create table items
(
    id               bigserial
        constraint items_pkey primary key,
    created_at       timestamp    not null,
    created_by       varchar(255) not null,
    last_modified_at timestamp    not null,
    last_modified_by varchar(255) not null,
    version          smallint,
    item_id          varchar(255) not null unique,
    name             varchar(255) not null unique,
    qty              integer      not null
);

create sequence hibernate_sequence
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

create table rev_info
(
    id           integer      not null
        constraint rev_info_pkey
            primary key default NEXTVAL('hibernate_sequence'),
    timestamp    bigint       not null,
    triggered_by varchar(255) not null
);

alter sequence hibernate_sequence owned by rev_info.id;

create table items_aud
(
    id               bigint  not null,
    rev              integer not null
        constraint items_aud_2_revinfo
            references rev_info,
    revtype          smallint,
    created_at       timestamp,
    created_by       varchar(255),
    last_modified_at timestamp,
    last_modified_by varchar(255),
    item_id           varchar(255),
    name             varchar(255),
    qty              integer,
    constraint items_aud_pkey
        primary key (id, rev)
);
