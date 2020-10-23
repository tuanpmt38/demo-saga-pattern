-- liquibase formatted sql
-- changeset tuanpm:01

drop table if exists debt_order;
create table debt_order
(
    id                serial primary key,
    order_id          bigint,
    total_amount_debt     decimal      not null default 0.0
);
