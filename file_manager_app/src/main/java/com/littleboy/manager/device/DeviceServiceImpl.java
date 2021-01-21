package com.littleboy.manager.device;

import com.littleboy.manager.api.DeviceServiceI;
import com.littleboy.manager.device.executor.query.DeviceByIdQryExe;
import com.littleboy.manager.dto.DeviceByIdQry;
import com.littleboy.manager.dto.data.DeviceDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author littleboy
 */
@Service
public class DeviceServiceImpl implements DeviceServiceI {

	@Resource
	private DeviceByIdQryExe mDeviceByIdQryExe;

	@Override
	public DeviceDTO getDeviceById(DeviceByIdQry deviceByIdQry) {
		return mDeviceByIdQryExe.execute(deviceByIdQry);
	}
}
