package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class File implements Serializable {

	private static final long serialVersionUID = -6446936696907562299L;

	private int fileId;
	private String fileName;
	private int folderId;
	private int typeId;
	private int userId;
	private String createTime;
	private String owner;
	private int status;
	private String hdfsPath;
	private int fileSize;
	private String mark;


}
