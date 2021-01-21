
drop table if exists lb_manager_file_devices;
create table lb_manager_file_devices(
    id              int(11)         identity comment '主键id',
    device_type_id  int(11)         comment '设备类型id',
    device_name     varchar(50)     comment '设备名称',
    create_time     datetime        comment '创建时间',
    update_time     datetime        comment '更新时间',
    buy_time        datetime        comment '购买时间',
    price           decimal(4)   comment '价格',
    device_avatar   varchar(255)    comment '设备图标',
    comment         varchar(255)    comment '说明'
);

insert into lb_manager_file_devices values(1, 1, '手机1', '2021-01-19 00:00:00', '2021-01-19 00:00:00', '2021-01-19 00:00:00', 8000.00, '', '手机');
insert into lb_manager_file_devices values(2, 1, '手机2', '2021-01-19 00:00:00', '2021-01-19 00:00:00', '2021-01-19 00:00:00', 8000.00, '', '手机');
insert into lb_manager_file_devices values(3, 2, '笔记本1', '2021-01-19 00:00:00', '2021-01-19 00:00:00', '2021-01-19 00:00:00', 8000.00, '', '手机');
insert into lb_manager_file_devices values(4, 2, '笔记本2', '2021-01-19 00:00:00', '2021-01-19 00:00:00', '2021-01-19 00:00:00', 8000.00, '', '手机');
