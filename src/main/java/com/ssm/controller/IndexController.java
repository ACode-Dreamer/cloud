package com.ssm.controller;

import com.alibaba.fastjson.JSON;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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



    @RequestMapping("/error")
    public String error() throws Exception {
        throw new Exception("错误");
    }


    @RequestMapping("/translate")
    public String translate(@RequestParam("local") String locale, HttpSession session) {
        if ("zh".equals(locale)) {
            Locale locale1 = new Locale("zh","CN");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);
        }else {
            Locale locale1 = new Locale("en","US");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);
        }
            return "index";
    }

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
    public String recycle(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //查询被删除的文件
        List<File> fileList = fileService.queryRecycle(user.getUserid());
        session.setAttribute("fileList",fileList);
        //查询被删除的目录
        List<Folder> folderList = folderService.queryRecyclePath(user.getUserid());
        session.setAttribute("folderList",folderList);
        return "recycle";
    }
}
