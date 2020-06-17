package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
/**
 * 目录
 */
@Data
public class Folder implements Serializable {
	//目录id
	private Integer folderid;
	//目录名
	private String foldername;

	private String hdfspath;
	//父目录id
	private Integer parentid;

	private String owner;
	//用户id
	private Integer userid;
	//创建时间
	private String createtime;

	private Integer status;

	private String mark;

	private static final long serialVersionUID = 1L;


}
