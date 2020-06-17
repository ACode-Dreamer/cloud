package com.ssm.service.impl;

import com.ssm.dao.FileDao;
import com.ssm.pojo.File;
import com.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netdisc
 * @description:文件服务
 * @author: Mr.Gu
 * @create: 2020-06-15 21:41
 **/
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    /**
     * 查询文件根据用户
     * @param userId
     * @return
     */
    @Override
    public List<File> queryFile(int userId) {
        return fileDao.queryFile(userId);
    }

    /**
     * 插入文件
     * @param file
     * @return
     */
    @Override
    public int insertFile(File file) {
        return fileDao.insertFile(file);
    }

    /**
     * 根据id查文件
     * @param fileId
     * @return
     */
    @Override
    public File queryFileById(int fileId) {
        return fileDao.queryFileById(fileId);
    }

    /**
     * 根据目录和用户id查文件
     * @param
     * @return
     */
    @Override
    public List<File> queryFileByFolder(int folderid,int userId) {
        return fileDao.queryFileByFolder(folderid,userId);
    }
}
