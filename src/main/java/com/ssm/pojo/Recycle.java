package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Recycle implements Serializable {

	private static final long serialVersionUID = -568683577778696440L;
	private int fileId;
	private String fileName;
	private int folderId;
	private int typeId;
	private int userId;
	private String deleteTime;
	private String owner;
	private int status;
	private String hdfsPath;
	private int fileSize;
	private String mark;


}
