package com.ssm.service.impl;

import com.ssm.dao.FileDao;
import com.ssm.pojo.File;
import com.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:41
 **/
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public List<File> queryFile(int userId) {
        return fileDao.queryFile(userId);
    }
}
