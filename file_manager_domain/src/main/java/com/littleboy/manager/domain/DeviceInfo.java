package com.littleboy.manager.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 设备简要信息
 * @author littleboy
 */
@Data
@Builder
public class DeviceInfo {
	private Long 		id;
	private String 		deviceName;
	/**
	 * 设备图标
	 */
	private String 		deviceAvatar;
	private DeviceType  mDeviceType;
}
