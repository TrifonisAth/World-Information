package com.example.worldinfo.worldinfoservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.worldinfo.worldinfoservice.mappers")
public class MyBatisConfig {
}
