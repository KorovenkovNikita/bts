--liquibase formatted sql
--changeset nikita.korovenkov:bts-2
create table address
(
    id      bigint auto_increment
        primary key,
    city    varchar(255) not null,
    address varchar(255) not null
);
create table stock
(
    id           bigint auto_increment
        primary key,
    title        varchar(255) not null,
    opening_time TIME,
    closing_time TIME,
    address_id   bigint  null,
    constraint FKT3LgujPo83S9AO9uhne8Joycj
        foreign key (address_id) references address (id)
);

create table product
(
    id          bigint auto_increment
        primary key,
    laptop_id   bigint not null,
    stock_id bigint null,
    constraint FKWXZ40Qm7ljnnDBuFacKmi7a61
        foreign key (laptop_id) references laptop (id),
    constraint FKePM3TRYzm7e3SGWe6Xndc1Xkl
        foreign key (stock_id) references stock (id)
);
--rollback DROP TABLE address;
--rollback DROP TABLE stock;
--rollback DROP TABLE product;
