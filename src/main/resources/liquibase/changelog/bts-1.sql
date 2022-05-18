--liquibase formatted sql
--changeset nikita.korovenkov:bts-1
create table processor
(
    id                     bigint auto_increment
        primary key,
    processor_manufacturer varchar(300) null,
    processor_model        varchar(255) null,
    processor_number       varchar(255) null
);
create table screen
(
    id                        bigint auto_increment
        primary key,
    screen_brightness         varchar(255) null,
    screen_diagonal_in_inches varchar(255) null,
    screen_resolution         varchar(255) null
);
create table graphic_card
(
    id           bigint auto_increment
        primary key,
    manufacturer varchar(255) null,
    memory       int not null,
    model_number varchar(255) null
);
create table laptop
(
    id              bigint auto_increment
        primary key,
    name            varchar(255) null,
    graphic_card_id bigint null,
    processor_id    bigint null,
    screen_id       bigint null,
    constraint FK1dsxk7e8ypysp97ymdqxclm75
        foreign key (graphic_card_id) references graphic_card (id),
    constraint FK6xrunp3ky90hg244hix9mtt7a
        foreign key (screen_id) references screen (id),
    constraint FKf3aoiscc7f0edlltdxy1s0fw6
        foreign key (processor_id) references processor (id)
);
create table user
(
    id        bigint auto_increment
        primary key,
    full_name varchar(255) null,
    email     varchar(255) null
);
create table bucket
(
    date    datetime null,
    user_id bigint not null
        primary key,
    constraint FKql6bmsmds3jinwe5uvlwx11cs
        foreign key (user_id) references user (id)
);
create table bucket_laptops
(
    bucket_user_id bigint not null,
    laptops_id     bigint not null,
    constraint FK33dw8yx33tik65gvu8ygusyt
        foreign key (laptops_id) references laptop (id),
    constraint FKe7mrbuo8w82fuo5ee11jwyo26
        foreign key (bucket_user_id) references bucket (user_id)
);

--rollback DROP TABLE bucket_laptops;
--rollback DROP TABLE bucket;
--rollback DROP TABLE laptop;
--rollback DROP TABLE processor;
--rollback DROP TABLE screen;
--rollback DROP TABLE graphic_card;
--rollback DROP TABLE user;
