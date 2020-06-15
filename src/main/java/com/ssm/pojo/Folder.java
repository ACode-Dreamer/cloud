package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Folder implements Serializable {

	private static final long serialVersionUID = 2636367112801060878L;
	private int folderId;
	private String folderName;
	private String hdfsPath;
	private int parentId;
	private String owner;
	private int userId;
	private String createTime;
	private int status;
	private String mark;


}
