-- liquibase formatted sql
-- changeset tuanpm:01

drop table if exists odr_order;
create table odr_order
(
    id                serial primary key,
    pre_total_amount  decimal      not null default 0.0,
    vat               decimal,
    total_amount      decimal      not null default 0.0
);
