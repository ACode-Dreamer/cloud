package com.ssm.service.impl;

import com.ssm.dao.FileDao;
import com.ssm.pojo.File;
import com.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 查询用户的文件
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
     * 根据文件id查文件
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

    /**
     * 根据名称查文件
     * @param Name
     * @return
     */
//    @Override
//    public List<File> queryFileByName(String Name) {
//        return fileDao.queryFileByName(Name);
//    }

    /**
     * 根据时间查文件
     * @param Time
     * @return
     */
//    @Override
//    public List<File> queryFileByTime(String Time) {
//        return fileDao.queryFileByTime(Time);
//    }

    /**
     * 根据两个条件查询
     * @param condition
     * @return
     */
    @Override
    @Transactional
    public List<File> queryFileByCondition(String condition,int userId) {
        List<File> fileList = fileDao.queryFileByName(condition,userId);
        List<File> fileListOther = fileDao.queryFileByTime(condition,userId);
        fileList.addAll(fileListOther);
        return fileList;
    }

    /**
     * flag删除
     * @param fileId
     * @return
     */
    @Override
    public int deleteFile(int fileId) {
        return fileDao.deleteFile(fileId);
    }

    /**
     * 查询所有删除的文件
     * @param userid
     * @return
     */
    @Override
    public List<File> queryRecycle(int userid) {
        return fileDao.queryRecycle(userid);
    }

    /**
     * 移除文件
     * @param fileId
     * @return
     */
    @Override
    public int removeFile(int fileId) {
        return fileDao.removeFile(fileId);
    }
}
