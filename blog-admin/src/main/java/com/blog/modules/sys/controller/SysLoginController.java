package com.blog.modules.sys.controller;


import com.blog.modules.sys.entity.SysUserEntity;
import com.blog.modules.sys.form.SysLoginForm;
import com.blog.modules.sys.service.SysCaptchaService;
import com.blog.modules.sys.service.SysUserService;
import com.blog.modules.sys.service.SysUserTokenService;
import com.common.utils.R;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
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
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 验证码
     */
    @GetMapping("/img/captcha")
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

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }

        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

        //账号不存在，密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())){
            return R.error("账号或密码不正确");
        }

        if(user.getStatus() == 0){
            return R.error("账号已被锁定，请联系管理员");
        }

        //生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getUserId());
        System.out.println("登录成功");
        return null;
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public R logout() {
        sysUserTokenService.logout(1);
        return R.ok();
    }


}
