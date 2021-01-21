package com.littleboy.manager.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author littleboy
 */
@Configuration
@MapperScan("com.littleboy.manager.device.mapper")
@EnableTransactionManagement(order = 2)
public class MybatisConfig {
}
