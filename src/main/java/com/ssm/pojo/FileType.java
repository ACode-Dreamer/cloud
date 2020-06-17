package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;
/**
 * 文件类型
 */
@Data
public class FileType implements Serializable {

	private Integer typeid;

	private String typename;

	private static final long serialVersionUID = 1L;


}
