package com.ssm.service;

import com.ssm.pojo.File;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:40
 **/
public interface FileService {
    List<File> queryFile(int userId);
}
