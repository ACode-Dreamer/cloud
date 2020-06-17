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

    /**
     * 根据父目录id和用户id查询目录
     * @param folderid
     * @param userId
     * @return
     */
    List<Folder> queryFolderByFolder(@Param("folderId") int folderid,@Param("userId") int userId);

    /**
     * 根据目录名查目录信息
     * @param currentFolder
     * @return
     */
    Folder queryFolderByName(String currentFolder);


    /**
     * 查询所有删除的目录
     * @param userid
     * @return
     */
    List<Folder> queryRecyclePath(int userid);

    /**
     * flag删除目录
     * @param folderId
     * @return
     */
    int deleteFolder(int folderId);

    /**
     * 移除目录
     * @param folderId
     * @return
     */
    int removeFolder(int folderId);
}
