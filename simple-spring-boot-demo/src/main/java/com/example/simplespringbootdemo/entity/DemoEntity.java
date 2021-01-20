package com.example.simplespringbootdemo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 实体类
 */
@Data
@TableName("tb_demo")
public class DemoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Date createTime;

}
