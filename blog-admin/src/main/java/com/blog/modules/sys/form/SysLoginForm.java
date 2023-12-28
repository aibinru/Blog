package com.blog.modules.sys.form;

import lombok.Data;

/**
 * @author:艾宾如
 * @createDate:2023/5/30
 * @description:登录表单
 **/
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
