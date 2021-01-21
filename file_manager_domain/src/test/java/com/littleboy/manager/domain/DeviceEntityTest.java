package com.littleboy.manager.domain;

import com.littleboy.manager.domain.gateway.DeviceGateway;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceEntityTest {

	/**
	 * 模拟gateway实现并进行测试
	 */
	@Test
	public void testDeviceGateway() {
		DeviceGateway deviceGateway = new DeviceGatewayImpl();

		Assert.notNull(deviceGateway.getDeviceDetailById(1L), "error");

		Assert.isNull(deviceGateway.getDeviceDetailById(2L), "error");

		Assert.notEmpty(deviceGateway.getDeviceListByDeviceTypeId(1), "error");
	}

	/**
	 * mock deviceGateway implementation
	 */
	static class DeviceGatewayImpl implements DeviceGateway {

		@Override
		public DeviceDetail getDeviceDetailById(Long id) {
			if (id == 1) {
				return getNewDeviceDetail();
			}
			return null;
		}

		@Override
		public DeviceInfo getDeviceInfoById(Long id) {
			if (id == 1) {
				return getNewDeviceInfo();
			}
			return null;
		}

		@Override
		public List<DeviceInfo> getDeviceListByDeviceTypeId(Integer typeId) {
			for (DeviceType type : DeviceType.values()) {
				if (typeId == type.ordinal()) {
					List<DeviceInfo> deviceInfoList = new ArrayList<>();
					deviceInfoList.add(getNewDeviceInfo());
					return deviceInfoList;
				}
			}
			return null;
		}

		private DeviceDetail getNewDeviceDetail() {
			return DeviceDetail.builder()
					.id(1L)
					.price(100D)
					.createTime(new Date())
					.buyTime(new Date())
					.updateTime(new Date())
					.deviceName("测试")
					.mDeviceType(DeviceType.PHONE)
					.deviceAvatar("/test.png")
					.comment("测试")
					.build();
		}

		private DeviceInfo getNewDeviceInfo() {
			return DeviceInfo.builder()
					.id(1L)
					.deviceName("测试")
					.mDeviceType(DeviceType.PHONE)
					.deviceAvatar("/test.png")
					.build();
		}
	}
}
