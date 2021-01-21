package com.littleboy.manager.device.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.littleboy.manager.device.DeviceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 设备mapper
 * @author littleboy
 */
@Component
@Mapper
public interface DeviceMapper extends BaseMapper<DeviceDO> {

	/**
	 * 根据设备id获取设备信息
	 * @param deviceId 设备id
	 * @return 设备信息
	 */
	@Select("SELECT * FROM lb_manager_file_devices where id = #{deviceId}")
	DeviceDO getDeviceById(@Param("deviceId") Long deviceId);

	/**
	 * 根据设备类型id获取设备列表
	 * @param deviceTypeId 设备类型id
	 * @return
	 */
	List<DeviceDO> getDeviceListByDeviceTypeId(Integer deviceTypeId);

	/**
	 * 根据设备类型和用户获取设备列表
	 * @param DeviceTypeId 设备类型id
	 * @param userId       用户id
	 * @return 设备列表
	 */
	List<DeviceDO> getDeviceListByDeviceTypeIdAndUserId(Long DeviceTypeId, Long userId);
}
