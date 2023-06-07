package com.blog.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.admin.modules.sys.entity.SysCaptchaEntity;

import java.awt.image.BufferedImage;

/**
 * @author:艾宾如
 * @createDate:2023/5/29
 * @description:
 **/
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码校验
     * @param uuid
     * @param code 验证码
     * @return TRUE 成功      FALSE 失败
     */
    boolean validate(String uuid, String code);
}
