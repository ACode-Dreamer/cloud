package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Folder implements Serializable {
	private Integer folderid;

	private String foldername;

	private String hdfspath;

	private Integer parentid;

	private String owner;

	private Integer userid;

	private String createtime;

	private Integer status;

	private String mark;

	private static final long serialVersionUID = 1L;


}
