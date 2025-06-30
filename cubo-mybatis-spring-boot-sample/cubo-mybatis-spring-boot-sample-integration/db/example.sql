drop database if exists mybatis_spring_boot_sample_integration;
create database mybatis_spring_boot_sample_integration;

drop table if exists mybatis_spring_boot_sample_integration.`user`;
create table if not exists mybatis_spring_boot_sample_integration.`user`
(
    `id`           bigint unsigned auto_increment comment '自增主键' primary key,
    `phone`        varchar(11)                         not null comment '用户电话号码',
    `user_name`    varchar(64)                         not null comment '用户名',
    `gender`       tinyint(4)                          not null comment '性别',
    `nick_name`    varchar(64)                         not null comment '姓名',
    `company_name` varchar(64)                         not null comment '公司名称',
    `password`     varchar(128)                        not null comment '密码',
    `salt`         varchar(128)                        not null comment '密码加密盐值',
    `api_key`      varchar(50)                         null comment 'open api key',
    `secret_key`   varchar(50)                         null comment 'open api secret key',
    `email`        varchar(128)                        null comment '用户邮箱',
    `state`   tinyint(4) unsigned not null default 0 comment '用户状态:0: 未审核, 1: 审核中, 2: 审核未通过, 3: 已锁定, 4: 正常',
    `deleted` bigint default 0    not null comment '是否删除: 0-未删除, 大于 1 为已删除',
    `create_time`  timestamp default current_timestamp not null comment '创建时间 (公共字段)',
    `update_time`  timestamp default current_timestamp not null comment '最后更新时间 (公共字段)'
) comment '用户信息表' engine = InnoDB
                       charset = utf8mb4
                       collate = utf8mb4_general_ci;

create index user_info_phone_index on mybatis_spring_boot_sample_integration.`user` (phone);

create index user_info_username_index on mybatis_spring_boot_sample_integration.`user` (user_name);

insert into mybatis_spring_boot_sample_integration.user (id, phone, user_name, gender, nick_name, company_name, password, salt, api_key,
                                                         secret_key, email, state,
                                                         deleted, create_time, update_time)
values (1, '18000000000', 'dong4j', 1, 'dong4j', 'iHome', '000000', '000000', '000000', '000000', 'dong4j@gmail.com', 4, 0,
        '2019-09-25 18:02:21', '2019-09-25 18:02:21');


create table mybatis_spring_boot_sample_integration.rule
(
    id            bigint auto_increment primary key,
    ip_from       bigint                              null comment 'IP范围开始地址',
    ip_to         bigint                              null comment 'IP范围结束地址',
    match_mode    varchar(20)                         null comment '域名匹配模式',
    name          varchar(100)                        null comment '匹配的域名',
    priority      int                                 null comment '匹配优先级',
    enabled       bit(1)    default b'1'              null comment '是否启用',
    dispatch_mode varchar(20)                         null comment '分发模式, 如iphash、round-robin、random',
    deleted bigint default 0 not null comment '是否删除: 0-未删除, 大于 1 为已删除',
    create_time   timestamp default current_timestamp not null comment '创建时间 (公共字段)',
    update_time   timestamp default current_timestamp not null comment '最后更新时间 (公共字段)'
) comment '解析规则' charset = utf8mb4
                     collate = utf8mb4_general_ci;

insert into mybatis_spring_boot_sample_integration.rule (id, ip_from, ip_to, match_mode, name, priority, enabled, dispatch_mode,
                                                         deleted, create_time, update_time)
values (1, 2130706433, 2130706687, 'equals', 'nacos.server', 0, true, 'round-robin', 0, '2019-10-09 12:01:28', '2019-10-09 13:49:37');
insert into mybatis_spring_boot_sample_integration.rule (id, ip_from, ip_to, match_mode, name, priority, enabled, dispatch_mode,
                                                         deleted, create_time, update_time)
values (2, 3232235777, 3232236031, 'equals', 'nacos.server', 0, true, 'round-robin', 0, '2019-10-10 16:38:46', '2019-10-10 16:38:46');
