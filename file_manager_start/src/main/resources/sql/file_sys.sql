-- create database my_whole_manager default charset utf8mb4; 

use my_whole_manager;

drop table if exists lb_company;
create table lb_company(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
    `company_name` VARCHAR(50) NOT NULL comment '公司名',
    `logo` VARCHAR(100) default null comment '公司图片',
    `address` VARCHAR(200) NOT NULL comment '电子邮件',
    `create_time` datetime NOT NULL comment '创建时间',
    UNIQUE company_name_index (company_name(20)) comment '公司名索引',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '公司表' DEFAULT CHARSET=utf8mb4;

-- file manager
drop table if exists lb_file;
create table lb_file(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
    `file_name` varchar(50) not null comment '文件名称',
    `type_id` bigint(20) not null comment '文件类型',
    `user_id` bigint(20) not null comment '所属用户',
    `source` varchar(200) not null comment '文件来源',
    `comment` varchar(200) default null comment '文件说明',
    `status` int(1) default 1 comment '1 状态正常 -1 删除',
    `create_time` datetime NOT NULL comment '创建时间',
    `update_time` datetime NOT NULL comment '更新时间',
    `delete_time` datetime NOT NULL comment '删除时间',
    `recovery_time` datetime NOT NULL comment '恢复时间',
    index type_id_index (type_id) comment '文件类型索引',
    primary key (id)
) ENGINE=InnoDB COMMENT '公司表' DEFAULT CHARSET=utf8mb4;

drop table if exists lb_file_type;
create table lb_file_type(
	`id` bigint(20) not null auto_increment comment '主键, 自增',
    `type_name` varchar(50) not null comment '类型名称',
    `user_id` bigint(20) not null comment '所属用户',
    `create_time` datetime NOT NULL comment '创建时间',
    UNIQUE type_name_index (type_name(20)) comment '类型名称索引',
    primary key (id)
) ENGINE=InnoDB COMMENT '文件类型表' DEFAULT CHARSET=utf8mb4;