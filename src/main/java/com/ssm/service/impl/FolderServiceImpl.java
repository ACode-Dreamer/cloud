package com.ssm.service.impl;

import com.ssm.dao.FolderDao;
import com.ssm.pojo.Folder;
import com.ssm.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 22:01
 **/
@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderDao folderDao;

    @Override
    public List<Folder> queryFolder(int userId) {
        return folderDao.queryFolder(userId);
    }
}
