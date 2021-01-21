package com.littleboy.manager.api;

import com.littleboy.manager.dto.DeviceByIdQry;
import com.littleboy.manager.dto.data.DeviceDTO;

public interface DeviceServiceI {

	/**
	 * 根据id获取设备详情
	 * @param deviceByIdQry
	 * @return 设备详情
	 */
	DeviceDTO getDeviceById(DeviceByIdQry deviceByIdQry);
}
