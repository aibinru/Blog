package com.blog.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author:艾宾如
 * @createDate:2023/5/31
 * @description:
 **/
@TableName("user")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
