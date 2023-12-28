package com.blog.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.modules.sys.dao.SysCaptchaDao;
import com.blog.modules.sys.entity.SysCaptchaEntity;
import com.blog.modules.sys.service.SysCaptchaService;
import com.common.utils.DateUtils;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @author:艾宾如
 * @createDate:2023/5/29
 * @description:
 **/
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {

    @Autowired
    private Producer producer;
    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            //throw new RRException("uuid不能为空");
        }
        String code = producer.createText();
        SysCaptchaEntity captchaEntity = new SysCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(),30));
        this.save(captchaEntity);
        return producer.createImage(code);
    }


    @Override
    public boolean validate( String code) {
        SysCaptchaEntity captchaEntity = this.getOne(new QueryWrapper<SysCaptchaEntity>().eq("code",code));
        if (captchaEntity == null) {
            return false;
        }
        //删除验证码
        this.removeById(code);

        if (captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }
}
