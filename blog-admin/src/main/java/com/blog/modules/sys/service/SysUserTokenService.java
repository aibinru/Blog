package com.blog.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.modules.sys.entity.SysUserTokenEntity;
import com.common.utils.R;

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
