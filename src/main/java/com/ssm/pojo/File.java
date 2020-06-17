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
	//文件夹id
	private Integer folderid;

	private Integer typeid;

	private Integer userid;

	private String createtime;

	private String owner;

	private Integer status;

	private String hdfspath;

	private Long filesize;

	private String mark;

	private static final long serialVersionUID = 1L;

}
