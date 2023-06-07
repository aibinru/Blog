package com.blog.admin.modules.sys.controller;

import com.blog.admin.modules.sys.service.SysCaptchaService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

/**
 * @author:艾宾如
 * @createDate:2023/5/29
 * @description:登录相关
 **/
@RestController
public class SysLoginController {

    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     */
    @GetMapping("captcha")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");

        //生存UUID
        UUID uuid= UUID.randomUUID();

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid.toString());

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
}
