package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 20:49
 **/
public class LoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        if(requestURI.equals("/register") || requestURI.equals("/login")){
            //登录注册页面不校验
            return true;
        }else{
            //进行用户名校验
            if(session.getAttribute("user")!=null){
                //已登录
                return true;
            }else{
                //未登录
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
