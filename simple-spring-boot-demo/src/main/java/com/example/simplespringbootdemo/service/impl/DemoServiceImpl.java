package com.example.simplespringbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.simplespringbootdemo.entity.DemoEntity;
import com.example.simplespringbootdemo.mapper.DemoMapper;
import com.example.simplespringbootdemo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {
}

