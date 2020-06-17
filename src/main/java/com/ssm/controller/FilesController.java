package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.FileType;
import com.ssm.pojo.Folder;
import com.ssm.pojo.User;
import com.ssm.service.FileService;
import com.ssm.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: netdisc
 * @description:文件控制
 * @author: Mr.Gu
 * @create: 2020-06-15 21:18
 **/
@Controller
public class FilesController {

    private String filePath = "http://localhost:8080/netdisc";
    private String localPath = "C:\\Users\\11469\\IdeaProjects\\community\\netdisc\\netdisc";

    @Autowired
    private FileService fileService;

    @Autowired
    private FolderService folderService;


    /**
     * 彻底删除目录
     */
    @RequestMapping("/removeFolder")
    @ResponseBody
    public String removeFolder(@RequestParam("folderId") int folderId){
        int deleteFile = folderService.removeFolder(folderId);
        if(deleteFile!=0){
            return JSON.toJSONString("success");
        }else{
            return JSON.toJSONString("failed");
        }
    }

    /**
     * 彻底删除文件
     */
    @RequestMapping("/remove")
    @ResponseBody
    public String remove(@RequestParam("fileId") int fileId){
        int deleteFile = fileService.removeFile(fileId);
        if(deleteFile!=0){
            return JSON.toJSONString("success");
        }else{
            return JSON.toJSONString("failed");
        }
    }
    /**
     * flag删除目录
     */
    @RequestMapping("/deleteFolder")
    @ResponseBody
    public String deleteFolder(@RequestParam("folderId") int folderId){
        int deleteFile = folderService.deleteFolder(folderId);
        if(deleteFile!=0){
            return JSON.toJSONString("success");
        }else{
            return JSON.toJSONString("failed");
        }
    }


    /**
     * flag删除文件
     * @param fileId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("fileId") int fileId){
        int deleteFile = fileService.deleteFile(fileId);
        if(deleteFile!=0){
            return JSON.toJSONString("success");
        }else{
            return JSON.toJSONString("failed");
        }
    }

    /**
     * 搜索文件
     */
    @RequestMapping("/search")
    public String searchFile(String condition, HttpSession session){
        //用户
        User user = (User) session.getAttribute("user");
        List<com.ssm.pojo.File> fileList =   fileService.queryFileByCondition(condition,user.getUserid());
        session.setAttribute("fileList", fileList);
        session.removeAttribute("folderList");
        return "index";
    }

    /**
     * 切换目录
     */
    @RequestMapping("switchFolder")
    public String switchFolder(int folderid, String foldername, HttpSession session) {
        //用户
        User user = (User) session.getAttribute("user");
        //查询目录下的的目录
        List<Folder> folderList = folderService.queryFolderByFolder(folderid, user.getUserid());
        session.setAttribute("folderList", folderList);
        //查询目录下的的文件
        List<com.ssm.pojo.File> fileList = fileService.queryFileByFolder(folderid, user.getUserid());
        session.setAttribute("fileList", fileList);
        //当前目录
        session.setAttribute("currentFolder", foldername);
        return "index";
    }

    /**
     * 上传页面
     */
    @RequestMapping("fileupload")
    public String fileupload() {
        return "fileupload";
    }


    /**
     * 下载页面
     */
    @RequestMapping("filedownload")
    public String filedownload() {
        return "filedownload";
    }


    /**
     * 下载文件
     */
    @RequestMapping(value = "download")
    public ResponseEntity download(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") int fileId) throws IOException {
        //查询文件信息
        com.ssm.pojo.File fileById = fileService.queryFileById(fileId);
        File file = new File(localPath +fileById.getHdfspath());
        //需要将文件转换为字节数组-将文件读取到字节数组
        //初始化文件读取流
        FileInputStream fis = new FileInputStream(file);
        //定义一个字节数组的长度与文件输入流读取的数据长度相同
        byte[] body = new byte[fis.available()];
        fis.read(body);
        //设置头信息 +注意文件名转码
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + new String(fileById.getFilename().getBytes("GBK"), "ISO8859_1"));
        //封装到ResponseEntity
        ResponseEntity entity = new ResponseEntity(body, headers, HttpStatus.OK);
        return entity;

    }

    /**
     * 创建目录
     *
     * @param folderName
     * @param session
     * @return
     */
    @RequestMapping("createFolder")
    public String createFolder(String folderName, HttpSession session) throws IOException {
        //当前目录
        String currentFolder = (String) session.getAttribute("currentFolder");
        //根据目录名查目录id
        Folder folderByName = folderService.queryFolderByName(currentFolder);
        //文件夹信息
        Folder folder = new Folder();
        folder.setFoldername(folderName);
        //父目录
        if (folderByName != null) {
            folder.setParentid(folderByName.getFolderid());
        }
        //用户
        User user = (User) session.getAttribute("user");
        folder.setUserid(user.getUserid());
        //日期
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        folder.setCreatetime(ft.format(date));
        folderService.insertFolder(folder);
        //创建目录
        File file = new File(localPath, folderName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return "/index";
    }


    /**
     * 上传文件
     *
     * @param file
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("uploadFile") MultipartFile file,
                         HttpSession session) throws IOException {
        //当前目录
        String currentFolder = (String) session.getAttribute("currentFolder");
        //根据目录名查目录id
        Folder folderByName = folderService.queryFolderByName(currentFolder);
        //取文件后缀
        String filename = file.getOriginalFilename();
        int suffixIndex = filename.lastIndexOf(".");
        String suffix = filename.substring(suffixIndex);
        //UUID加密
        UUID uuid = UUID.randomUUID();
        String lastName = uuid + suffix;
        //映射地址
        String path = filePath + "/" + lastName;
        //映射地址+文件信息入库
        com.ssm.pojo.File depositFile = new com.ssm.pojo.File();
        depositFile.setFilename(filename);
        //父目录
        if (folderByName != null) {
            depositFile.setFolderid(folderByName.getFolderid());
        }
        //用户
        User user = (User) session.getAttribute("user");
        depositFile.setUserid(user.getUserid());
        //日期
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        depositFile.setCreatetime(ft.format(date));
        //地址记录
        if (folderByName != null) {
            //不在根目录
            depositFile.setHdfspath( "\\" + folderByName.getFoldername() + "\\" + lastName);
        } else {
            depositFile.setHdfspath( "\\" + lastName);
        }
        //大小
        depositFile.setFilesize(file.getSize());
        //入库
        fileService.insertFile(depositFile);
        //真实地址下载
        //是否在根目录
        if (folderByName != null) {
            //不在根目录
            String fileDir = localPath + "\\" + folderByName.getFoldername() + "\\" + lastName;
            File realFile = new File(fileDir);
            file.transferTo(realFile);
        } else {
            //在根目录
            File realFile = new File(localPath, lastName);
            file.transferTo(realFile);
        }
        return "/index";
    }


}
