package com.littleboy.manager.dto.data;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author littleboy
 */
@Builder
@Data
public class DeviceDTO {
	private Long 		id;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private Date 		updateTime;
	private Date 		buyTime;
	private String 		deviceName;
	private Double 		price;

	/**
	 * 设备图标
	 */
	private String 		deviceAvatar;
	private String 		comment;
	private Integer		deviceTypeId;
}
