package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
/**
 * 用户
 */
@Data
public class User implements Serializable {
	//用户id
	private Integer userid;
	//用户名
	private String username;
	//用户密码
	private String password;
	//手机号
	private String telephone;
	//邮箱
	private String email;

	private Integer roleid;

	private String isvip;

	private Integer status;

	private static final long serialVersionUID = 1L;

}
