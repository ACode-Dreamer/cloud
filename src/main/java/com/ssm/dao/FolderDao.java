package com.ssm.dao;

import com.ssm.pojo.File;
import com.ssm.pojo.Folder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: netdisc
 * @description:文件夹持久
 * @author: Mr.Gu
 * @create: 2020-06-15 21:57
 **/
public interface FolderDao {
    /**
     * 根据用户id查询文件夹
     * @param userId
     * @return
     */
    List<Folder> queryFolder(int userId);

    /**
     * 插入文件夹
     * @param folder
     * @return
     */
    int insertFolder(Folder folder);

    List<Folder> queryFolderByFolder(@Param("folderId") int folderid,@Param("userId") int userId);

    Folder queryFolderByName(String currentFolder);
}
