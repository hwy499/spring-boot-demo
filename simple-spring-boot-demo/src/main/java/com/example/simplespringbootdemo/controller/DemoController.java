package com.example.simplespringbootdemo.controller;

import com.example.simplespringbootdemo.entity.DemoEntity;
import com.example.simplespringbootdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/{id}")
    public DemoEntity detail(@PathVariable("id") Integer id) {
        return demoService.getById(id);
    }

}
