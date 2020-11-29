package com.example.springbootredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -2148530064084520825L;
    /**
     * 用户Id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String u_name;
    /**
     * 用户性别
     */
    private String u_sex;

}
