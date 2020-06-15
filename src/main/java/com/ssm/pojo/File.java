package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class File implements Serializable {
	private Integer fileid;

	private String filename;

	private Integer folderid;

	private Integer typeid;

	private Integer userid;

	private String createtime;

	private String owner;

	private Integer status;

	private String hdfspath;

	private Integer filesize;

	private String mark;

	private static final long serialVersionUID = 1L;

}
