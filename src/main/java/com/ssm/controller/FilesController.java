package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 21:18
 **/
@Controller
@RequestMapping("/hdfs")
public class FilesController {

    @RequestMapping("")
    public String folder(String download){
        return "";
    }

}
