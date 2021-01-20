package com.example.simplespringbootdemo.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.websocket.mapper")
public class MybatisPlusConfig {
}
