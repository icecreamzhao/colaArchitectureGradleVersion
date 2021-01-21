package com.littleboy.manager.domain.gateway;

import com.littleboy.manager.domain.DeviceDetail;
import com.littleboy.manager.domain.DeviceInfo;

import java.util.List;

/**
 * device网关
 * @author littleboy
 */
public interface DeviceGateway {

	/**
	 * 根据id获取设备详情
	 * @param id
	 * @return 设备详情
	 */
	DeviceDetail getDeviceDetailById(Long id);

	/**
	 * 根据id获取设备信息
	 * @param id
	 * @return 设备信息, 只包括id, deviceName, deviceType 和 deviceAvatar
	 */
	DeviceInfo getDeviceInfoById(Long id);

	/**
	 * 根据设备类型id获取设备列表
	 * @param typeId 类型id
	 * @return 设备列表
	 */
	List<DeviceInfo> getDeviceListByDeviceTypeId(Integer typeId);
}
