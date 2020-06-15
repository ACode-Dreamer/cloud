package com.ssm.dao;

import com.ssm.pojo.File;
import com.ssm.pojo.Folder;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:57
 **/
public interface FolderDao {
    List<Folder> queryFolder(int userId);
}
