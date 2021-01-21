package com.littleboy.manager.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据id查询
 * @author littleboy
 */

@Data
public class DeviceByIdQry implements Serializable {
	private Long id;
}
