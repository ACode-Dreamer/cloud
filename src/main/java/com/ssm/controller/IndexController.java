package com.ssm.controller;

import com.ssm.dao.FiletypeDao;
import com.ssm.dao.FolderDao;
import com.ssm.pojo.File;
import com.ssm.pojo.FileType;
import com.ssm.pojo.Folder;
import com.ssm.pojo.User;
import com.ssm.service.FileService;
import com.ssm.service.FileTypeService;
import com.ssm.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: netdisc
 * @description:页面控制
 * @author: Mr.Gu
 * @create: 2020-06-15 16:17
 **/
@Controller
public class IndexController {
    @Autowired
    private FileService fileService;

    @Autowired
    private FolderService folderService;

    @Autowired
    private FileTypeService fileTypeService;

    /**
     * 管理主页
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<FileType> fileTypes = fileTypeService.selectFileType();
        session.setAttribute("sysFolderList",fileTypes);
        List<Folder> folderList = folderService.queryFolder(user.getUserid());
        session.setAttribute("folderList",folderList);
        List<File> fileList = fileService.queryFile(user.getUserid());
        session.setAttribute("fileList",fileList);
        //当前目录
        session.setAttribute("currentFolder","");
        return "index";
    }

    /**
     * 回收站页
     * @return
     */
    @RequestMapping("/recycle")
    public String recycle() {
        return "recycle";
    }
}
