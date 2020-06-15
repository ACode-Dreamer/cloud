package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 15:44
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register.do")
    public String userRegister(User user, Model model, HttpSession httpSession) {
        int existUser = userService.existUser(user);
        if (existUser == 0) {
            //不存在即注册
            int register = userService.register(user);
            if (register == 1) {
                //注册成功
                httpSession.setAttribute("user", user);
                    return "/index";
            } else {
                //注册失败
                model.addAttribute("msg", "注册失败");
                return "forward:register";
            }
        } else {
            //用户已存在
            model.addAttribute("msg", "用户已存在");
            return "forward:register";
        }
    }

    @RequestMapping("/login.do")
    public String userLogin(User user, Model model, HttpSession httpSession) {
        User login = userService.login(user);
        if (login == null) {
            //登录失败
            model.addAttribute("msg", "登录失败");
            return "forward:login";
        } else {
            //登录成功
            httpSession.setAttribute("user", user);
            return "/index";
        }
    }
}
