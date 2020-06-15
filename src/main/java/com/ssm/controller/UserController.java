package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 15:44
 **/
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String userRegister(User user, Model model, HttpSession httpSession) {
        int existUser = userService.existUser(user);
        if (existUser == 0) {
            //不存在即注册
            int register = userService.register(user);
            if (register == 1) {
                //注册成功
                //查询完整用户信息
                User login = userService.login(user);
                httpSession.setAttribute("user", login);
                    return "redirect:index";
            } else {
                //注册失败
                model.addAttribute("msg", "注册失败");
                return "register";
            }
        } else {
            //用户已存在
            model.addAttribute("msg", "用户已存在");
            return "register";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(User user, Model model, HttpSession httpSession) {
        User login = userService.login(user);
        if (login == null) {
            //登录失败
            model.addAttribute("msg", "登录失败");
            return "login";
        } else {
            //登录成功
            httpSession.setAttribute("user", login);
            return "redirect:index";
        }
    }
}
