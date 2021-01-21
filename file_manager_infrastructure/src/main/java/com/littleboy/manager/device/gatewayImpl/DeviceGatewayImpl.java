package com.littleboy.manager.device.gatewayImpl;

import com.littleboy.manager.device.DeviceDO;
import com.littleboy.manager.device.mapper.DeviceMapper;
import com.littleboy.manager.domain.DeviceDetail;
import com.littleboy.manager.domain.DeviceInfo;
import com.littleboy.manager.domain.DeviceType;
import com.littleboy.manager.domain.gateway.DeviceGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author littleboy
 */
@Component
public class DeviceGatewayImpl implements DeviceGateway {

	@Autowired
	private DeviceMapper mDeviceMapper;

	@Override
	public DeviceDetail getDeviceDetailById(Long id) {
		DeviceDO deviceDO = mDeviceMapper.getDeviceById(id);

		return convertDeviceDOToDeviceDetail(deviceDO);
	}

	@Override
	public DeviceInfo getDeviceInfoById(Long id) {
		DeviceDO deviceDO = mDeviceMapper.getDeviceById(id);

		return convertDeviceDOToDeviceInfo(deviceDO);
	}

	@Override
	public List<DeviceInfo> getDeviceListByDeviceTypeId(Integer typeId) {
		List<DeviceDO> deviceDOList = mDeviceMapper.getDeviceListByDeviceTypeId(typeId);
		List<DeviceInfo> deviceInfoList = new ArrayList<>();

		for (DeviceDO deviceDO : deviceDOList) {
			DeviceInfo deviceInfo = convertDeviceDOToDeviceInfo(deviceDO);
			deviceInfoList.add(deviceInfo);
		}
		return deviceInfoList;
	}

	/**
	 * 将 Data Object 转换成 entity
	 * @param deviceDO Data Object
	 * @return
	 */
	private DeviceDetail convertDeviceDOToDeviceDetail(DeviceDO deviceDO) {
		DeviceType deviceType = DeviceType.OTHER;

		for (DeviceType deviceType1 : DeviceType.values()) {
			if (deviceDO.getDeviceTypeId() == deviceType1.ordinal()) {
				deviceType = deviceType1;
			}
		}
		return DeviceDetail.builder()
				.id(deviceDO.getId())
				.deviceAvatar(deviceDO.getDeviceAvatar())
				.deviceName(deviceDO.getDeviceName())
				.deviceName(deviceDO.getDeviceName())
				.comment(deviceDO.getComment())
				.buyTime(deviceDO.getBuyTime())
				.updateTime(deviceDO.getUpdateTime())
				.createTime(deviceDO.getCreateTime())
				.mDeviceType(deviceType).build();
	}

	/**
	 * 将 Data Object 转换成 entity
	 * @param deviceDO
	 * @return
	 */
	private DeviceInfo convertDeviceDOToDeviceInfo(DeviceDO deviceDO) {
		DeviceDetail deviceDetail = convertDeviceDOToDeviceDetail(deviceDO);

		return DeviceInfo.builder()
				.id(deviceDetail.getId())
				.deviceAvatar(deviceDetail.getDeviceAvatar())
				.mDeviceType(deviceDetail.getMDeviceType())
				.deviceName(deviceDetail.getDeviceName())
				.build();
	}
}
