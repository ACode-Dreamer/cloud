package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: netdisc
 * @description:用户服务
 * @author: Mr.Gu
 * @create: 2020-06-15 17:01
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        return userDao.register(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    /**
     * 是否存在
     * @param user
     * @return
     */
    @Override
    public int existUser(User user) {
        return userDao.existUser(user);
    }

}
