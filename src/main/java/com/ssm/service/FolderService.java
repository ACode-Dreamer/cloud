package com.ssm.service;

import com.ssm.pojo.Folder;

import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 22:01
 **/
public interface FolderService {
    List<Folder> queryFolder(int userId);
    int insertFolder(Folder folder);
    List<Folder> queryFolderByFolder(int folderid, int userid);

    Folder queryFolderByName(String currentFolder);
    List<Folder> queryRecyclePath(int userid);

    int deleteFolder(int folderId);

    int removeFolder(int folderId);
}
