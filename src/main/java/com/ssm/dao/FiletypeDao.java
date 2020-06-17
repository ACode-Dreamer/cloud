package com.ssm.dao;

import com.ssm.pojo.FileType;

import java.util.List;

/**
 * @program: netdisc
 * @description:文件类型持久
 * @author: Mr.Gu
 * @create: 2020-06-15 21:33
 **/
public interface FiletypeDao {
    /**
     * 查询所有文件类型
     * @return
     */
    List<FileType> selectAllFileType();

}