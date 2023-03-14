package com.tedu.forum.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tedu.forum.mapper")
public class MyBatisConfig {
}
