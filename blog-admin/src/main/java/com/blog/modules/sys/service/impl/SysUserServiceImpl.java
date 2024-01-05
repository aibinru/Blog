package com.blog.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.modules.sys.dao.SysUserDao;
import com.blog.modules.sys.entity.SysUserEntity;
import com.blog.modules.sys.form.SysLoginForm;
import com.blog.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author aibinru:am19136754034@gmail.com
 * @date 24-1-2 11:23
 * @description:
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }
}
