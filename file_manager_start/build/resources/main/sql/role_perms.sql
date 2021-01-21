-- create database my_whole_manager default charset utf8mb4; 
use my_whole_manager;

-- user part
drop table if exists lb_user;
create table lb_user(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
    `user_name` VARCHAR(20) NOT NULL comment '用户名',
    `register_time` DATETIME NOT NULL comment '注册时间',
    `unregister_time` DATETIME DEFAULT NULL comment '注销时间',
    `email` VARCHAR(20) NOT NULL comment '电子邮件',
    `company_id` BIGINT(20) DEFAULT NULL comment '公司id',
    `passwd` varchar(70) NOT NULL comment '密码',
    `pic` varchar(500) default '' comment '用户头像',
    `status` tinyint(1) default 1 comment '状态 0: 禁用 1: 正常',
    UNIQUE file_name_index (user_name(20)) comment '文件名索引',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户表' DEFAULT CHARSET=utf8mb4;

drop table if exists lb_app_connect;
create table lb_app_connect(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
    `user_id` BIGINT(20) NOT NULL comment '系统用户id',
    `app_id` TINYINT(1) NOT NULL comment '第三方系统id',
    `nick_name` VARCHAR(50) NOT NULL comment '第三方系统昵称',
    `image_url` VARCHAR(200) NOT NULL comment '第三方系统头像',
    `biz_user_id` VARCHAR(50) NOT NULL comment '第三方系统userId',
    UNIQUE user_id_index (user_id) comment '系统用户id索引',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '第三方系统用户表' DEFAULT CHARSET=utf8mb4;

drop table if exists lb_role;
create table lb_role (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
	`role_name` VARCHAR(20) NOT NULL comment '角色名',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户角色表' DEFAULT CHARSET=utf8mb4;

drop table if exists lb_user_roles;
create table lb_user_roles (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT comment '主键, 自增',
    `user_id` BIGINT(20) NOT NULL comment '用户id',
    `role_id` BIGINT(20) NOT NULL comment '角色id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '用户角色表' DEFAULT CHARSET=utf8mb4;

drop table if exists lb_sys;
create table lb_sys(
	`id` bigint(20) not null auto_increment comment '主键, 自增',
    `name` varchar(20) not null comment '系统名称',
    primary key(id)
) engine=InnoDB comment '系统表' default charset=utf8mb4;

drop table if exists lb_menu;
create table lb_menu(
	`id` bigint(20) not null auto_increment comment '主键, 自增',
    `parent_id` bigint(20) not null comment '父菜单的id',
    `name` varchar(20) not null comment '菜单名称',
    `url` varchar(20) not null comment '菜单路径',
    `perms` varchar(500) default null comment '菜单权限, 多个用逗号分隔, 如: user:list,user:create',
    `type` tinyint(1) default 0 comment '类型 0:目录 1: 菜单 2: 按钮',
    `icon` varchar(50) not null comment '菜单图标',
    `order_num` int not null comment '排序',
    `sys_id` bigint(20) not null comment '系统id 用来判断是哪个系统的菜单',
    primary key (id)
) ENGINE=InnoDB COMMENT '文件管理菜单表' default charset=utf8mb4;

drop table if exists lb_role_menu;
create table lb_role_menu(
	`id` bigint(20) not null auto_increment comment '主键, 自增',
    `role_id` bigint(20) not null comment 'role id',
    `menu_id` bigint(20) not null comment 'menu id',
    primary key(id)
) engine=InnoDB comment '菜单和角色对应关系' default charset=utf8mb4;