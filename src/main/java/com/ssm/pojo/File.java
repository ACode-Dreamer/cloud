package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件
 */
@Data
public class File implements Serializable {
	//文件id
	private Integer fileid;
	//文件名
	private String filename;
	//所在目录id
	private Integer folderid;
	//文件类型
	private Integer typeid;
	//用户id
	private Integer userid;
	//创建时间
	private String createtime;

	private String owner;

	private Integer status;
	//所在地址
	private String hdfspath;
	//文件大小
	private Long filesize;

	private String mark;

	private static final long serialVersionUID = 1L;

}
