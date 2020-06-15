package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 16:17
 **/
@Controller
@RequestMapping("/index")
public class indexController {
    @RequestMapping("")
    public String index() {
        return "index";
    }
}
