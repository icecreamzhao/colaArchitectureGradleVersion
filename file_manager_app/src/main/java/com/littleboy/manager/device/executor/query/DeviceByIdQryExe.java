package com.littleboy.manager.device.executor.query;

import com.littleboy.manager.domain.DeviceDetail;
import com.littleboy.manager.domain.gateway.DeviceGateway;
import com.littleboy.manager.dto.DeviceByIdQry;
import com.littleboy.manager.dto.data.DeviceDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 根据id查询实现
 * @author littleboy
 */
@Component
public class DeviceByIdQryExe {

	@Resource
	private DeviceGateway mDeviceGateway;

	public DeviceDTO execute(DeviceByIdQry deviceByIdQry) {
		DeviceDetail deviceDetail = mDeviceGateway.getDeviceDetailById(deviceByIdQry.getId());

		return DeviceDTO.builder()
				.id(deviceDetail.getId())
				.deviceName(deviceDetail.getDeviceName())
				.deviceTypeId(deviceDetail.getMDeviceType().ordinal())
				.price(deviceDetail.getPrice())
				.buyTime(deviceDetail.getBuyTime())
				.createTime(deviceDetail.getCreateTime())
				.comment(deviceDetail.getComment())
				.updateTime(deviceDetail.getUpdateTime())
				.deviceAvatar(deviceDetail.getDeviceAvatar())
				.build();
	}
}
