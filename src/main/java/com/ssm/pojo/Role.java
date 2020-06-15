package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable{
	
	private static final long serialVersionUID = -6252969741749690678L;
	
	private int roleId;
	private String roleName;
	private int status;


}
