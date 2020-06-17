package com.ssm.service.impl;

import com.ssm.dao.FolderDao;
import com.ssm.pojo.Folder;
import com.ssm.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netdisc
 * @description:文件夹服务
 * @author: Mr.Gu
 * @create: 2020-06-15 22:01
 **/
@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderDao folderDao;

    /**
     * 查询用户目录
     * @param userId
     * @return
     */
    @Override
    public List<Folder> queryFolder(int userId) {
        return folderDao.queryFolder(userId);
    }

    /**
     * 插入目录
     * @param folder
     * @return
     */
    @Override
    public int insertFolder(Folder folder) {
        return folderDao.insertFolder(folder);
    }

    /**
     * 根据目录和用户id查目录
     * @param
     * @param userid
     * @return
     */
    @Override
    public List<Folder> queryFolderByFolder(int folderid, int userid) {
        return folderDao.queryFolderByFolder(folderid,userid);
    }

    /**
     * 根据名字查目录
     * @param currentFolder
     * @return
     */
    @Override
    public Folder queryFolderByName(String currentFolder) {
        return folderDao.queryFolderByName(currentFolder);
    }

    /**
     * 查询删除的目录
     * @param userid
     * @return
     */
    @Override
    public List<Folder> queryRecyclePath(int userid) {
        return folderDao.queryRecyclePath(userid);
    }

    /**
     * flag删除目录
     * @param folderId
     * @return
     */
    @Override
    public int deleteFolder(int folderId) {
        return folderDao.deleteFolder(folderId);
    }

    /**
     * 移除目录
     * @param folderId
     * @return
     */
    @Override
    public int removeFolder(int folderId) {
        return folderDao.removeFolder(folderId);
    }
}
