package com.blog.admin.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.admin.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:艾宾如
 * @createDate:2023/6/8
 * @description:
 **/
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
}
