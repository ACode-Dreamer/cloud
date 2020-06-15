package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileType implements Serializable {

	private static final long serialVersionUID = 3144291845175202659L;

	private int typeId;
	private String typeName;
	private String extension;
	private String mark;


}
