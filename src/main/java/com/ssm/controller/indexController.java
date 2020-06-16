package com.ssm.controller;

import com.ssm.dao.FolderDao;
import com.ssm.pojo.File;
import com.ssm.pojo.Folder;
import com.ssm.pojo.User;
import com.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 16:17
 **/
@Controller
public class indexController {
    @Autowired
    private FileService fileService;

    @Autowired
    private FolderDao folderDao;

    @RequestMapping("/index")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Folder> folderList = folderDao.queryFolder(user.getUserid());
        List<File> fileList = fileService.queryFile(user.getUserid());
        session.setAttribute("folderList",folderList);
        session.setAttribute("fileList",fileList);
        return "index";
    }
    @RequestMapping("/recycle")
    public String recycle() {
        return "recycle";
    }
}
