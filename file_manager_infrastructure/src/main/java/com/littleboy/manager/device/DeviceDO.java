package com.littleboy.manager.device;

import lombok.Data;

import java.util.Date;

/**
 * 设备信息
 * Data Object 数据模型
 * @author littleboy
 */
@Data
public class DeviceDO {
	private Long 	id;
	private Integer	deviceTypeId;
	private String 	deviceName;
	private Date	createTime;
	private Date	updateTime;
	private Date	buyTime;
	private Double 	price;
	private String 	deviceAvatar;
	private String	comment;
}
