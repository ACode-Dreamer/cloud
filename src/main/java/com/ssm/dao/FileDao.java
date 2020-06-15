package com.ssm.dao;

import com.ssm.pojo.File;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:33
 **/
public interface FileDao {
    List<File> queryFile(int userId);
}
