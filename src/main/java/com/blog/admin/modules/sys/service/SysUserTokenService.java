package com.blog.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.admin.common.utils.R;
import com.blog.admin.modules.sys.entity.SysUserTokenEntity;

/**
 * @author:艾宾如
 * @createDate:2023/6/8
 * @description:
 **/
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     * @param userId  用户ID
     * @return
     */
    R createToken(long userId);

    /**
     * 退出，修改token值
     * @param userId 用户ID
     */
    void logout(long userId);
}
