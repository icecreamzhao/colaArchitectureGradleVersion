package com.littleboy.manager.domain;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * 设备详情
 * entity 领域模型
 * @author littleboy
 */
@Data
@Builder
public class DeviceDetail {
	private Long 		id;

	/**
	 * 创建时间
	 */
	private Date 		createTime;

	private Date 		updateTime;
	private Date 		buyTime;
	private String 		deviceName;
	private Double 		price;

	/**
	 * 设备图标
	 */
	private String 		deviceAvatar;
	private String 		comment;
	private DeviceType 	mDeviceType;
}
