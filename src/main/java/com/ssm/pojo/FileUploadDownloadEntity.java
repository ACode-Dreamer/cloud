package com.ssm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileUploadDownloadEntity implements Serializable {

	private static final long serialVersionUID = -3441547917002724231L;
	// 文件名、下载路径、大小、进度、状态
	private String udName;
	private String udPath;
	private int udSize;
	private String udProcess;


}
