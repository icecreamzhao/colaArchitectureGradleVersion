package com.littleboy.manager.file.web;

import com.littleboy.manager.api.DeviceServiceI;
import com.littleboy.manager.dto.DeviceByIdQry;
import com.littleboy.manager.dto.data.DeviceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author littleboy
 */
@RestController

@Api(tags = "测试")
public class DeviceController {

	@Autowired
	private DeviceServiceI mDeviceServiceI;

	@ApiOperation("测试")
	@GetMapping(value = "/helloworld")
	public String helloWorld() {
		return "hello, world";
	}

	@GetMapping(value = "/device")
	public DeviceDTO getDeviceById(Long id) {
		DeviceByIdQry deviceByIdQry = new DeviceByIdQry();
		deviceByIdQry.setId(id);
		return mDeviceServiceI.getDeviceById(deviceByIdQry);
	}
}
