drop table if exists user_2018;

create table user_2018
(
    id    bigint(20) auto_increment comment '主键ID',
    name  varchar(30) null default null comment '姓名',
    age   int(11)     null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    primary key (id)
);

drop table if exists user_2019;

create table user_2019
(
    id    bigint(20) auto_increment comment '主键ID',
    name  varchar(30) null default null comment '姓名',
    age   int(11)     null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    primary key (id)
);

create table user_role
(
    id        bigint(20) auto_increment comment '主键ID',
    user_id   bigint(20)  not null comment '用户 id',
    role_name varchar(30) null default null comment '角色名',
    primary key (id)
);
