package com.ssm.service.impl;

import com.ssm.dao.FiletypeDao;
import com.ssm.pojo.FileType;
import com.ssm.service.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netdisc
 * @description:文件类型服务
 * @author: Mr.Gu
 * @create: 2020-06-16 18:37
 **/
@Service
public class FileTypeServiceImpl implements FileTypeService {
    @Autowired
    private FiletypeDao filetypeDao;

    /**
     * 查询所有文件类型
     * @return
     */
    @Override
    public List<FileType> selectFileType() {
        return filetypeDao.selectAllFileType();
    }
}
