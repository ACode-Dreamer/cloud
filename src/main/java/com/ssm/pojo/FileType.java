package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
/**
 * 文件类型
 */
@Data
public class FileType implements Serializable {
	//文件类型id
	private Integer typeid;
	//文件类型名
	private String typename;

	private static final long serialVersionUID = 1L;


}
