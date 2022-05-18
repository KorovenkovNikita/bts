--liquibase formatted sql
--changeset nikita.korovenkov:bts-2
create table stack
(
    id                 bigint auto_increment
        primary key,
    title              varchar(255) null,
    address            varchar(255) null,
    store_opening_time TIME,
    store_ending_time  TIME
);
create table stack_laptop
(
    quantity  int null,
    stack_id  bigint null,
    laptop_id bigint null,
    constraint FKOLcppi6GstaesWmMCMW79snHa
        foreign key (stack_id) references stack (id),
    constraint FKrpBX4EGIJ4mkOq7cYoYBS7y12
        foreign key (laptop_id) references laptop (id)
);
--rollback DROP TABLE stack_laptop;
--rollback DROP TABLE stack;
