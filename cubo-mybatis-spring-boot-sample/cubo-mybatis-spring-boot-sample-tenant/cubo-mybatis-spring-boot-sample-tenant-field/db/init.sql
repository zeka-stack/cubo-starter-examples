drop database if exists tenant;
create database tenant default charset utf8mb4;

use tenant;


drop table if exists tenant.`user`;
create table tenant.`user`
(
    `id`        int(11) not null auto_increment comment '主键',
    `name`      varchar(30) default null comment '姓名',
    `tenant_id` int(11) not null comment '多租户ID',
    primary key (`id`)
) engine = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '用户表';
