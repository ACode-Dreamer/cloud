package com.ssm.service;

import com.ssm.pojo.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:40
 **/
public interface FileService {
    List<File> queryFile(int userId);
    int insertFile(File file);
    File queryFileById(int fileId);
    List<File> queryFileByFolder(int folderid, int userId);

}
