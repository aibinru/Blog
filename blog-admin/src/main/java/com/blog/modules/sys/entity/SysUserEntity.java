package com.blog.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author abr
 * @email abr@gmail.com
 * @date 2023-06-08 21:36:18
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 头像
	 */
	private String ptoto;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 邮件
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 状态 0：禁用  1：正常
	 */
	private Integer status;
	/**
	 * 个人简介
	 */
	private String individualResume;
	/**
	 * 微信号
	 */
	private Integer wechatId;
	/**
	 * 创建者id
	 */
	private Integer createUserId;
	/**
	 * 创建者时间
	 */
	private Date createTime;
	/**
	 * 创建者
	 */
	private String crateOperator;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改者
	 */
	private Date updateOperator;
	/**
	 * 删除时间
	 */
	private String deleteTime;
	/**
	 * 删除者
	 */
	private String deleteOperator;

}
