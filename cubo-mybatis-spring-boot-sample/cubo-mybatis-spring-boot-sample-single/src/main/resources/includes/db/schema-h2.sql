drop table if exists user;

create table user
(
    id      bigint(20) auto_increment comment '主键ID',
    name    varchar(30) null default null comment '姓名',
    age     int(11)     null default null comment '年龄',
    email   varchar(50) null default null comment '邮箱',
    deleted bit(1)           default 0 not null comment '状态:0: 未删除 1: 已删除 (公共字段)',
    primary key (id)
);
