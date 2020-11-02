-- liquibase formatted sql
-- changeset tuanpm:01

drop table if exists car;
create table car
(
    id     serial primary key,
    model  varchar(255),
    year   INT
);
