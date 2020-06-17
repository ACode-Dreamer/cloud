package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
/**
 * 用户
 */
@Data
public class User implements Serializable {
	private Integer userid;

	private String username;

	private String password;

	private String telephone;

	private String email;

	private Integer roleid;

	private String isvip;

	private Integer status;

	private static final long serialVersionUID = 1L;

}
