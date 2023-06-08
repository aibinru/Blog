package com.blog.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author:艾宾如
 * @createDate:2023/5/29
 * @description:系统验证码
 **/
@Data
@TableName("sys_captcha")
public class SysCaptchaEntity {
    private String uuid;
    /**
     * 验证码
     */
    @TableId(type = IdType.INPUT)
    private String code;

    /**
     * 过期时间
     */
    private Date expireTime;
}
