package com.blog.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.modules.sys.entity.SysUserEntity;

/**
 * @author aibinru:am19136754034@gmail.com
 * @date 24-1-2 11:22
 * @description:
 */
public interface SysUserService extends IService<SysUserEntity> {
    SysUserEntity queryByUserName(String username);
}
