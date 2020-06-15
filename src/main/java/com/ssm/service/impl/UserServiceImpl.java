package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 17:01
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int register(User user) {
        return userDao.register(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public int existUser(User user) {
        return userDao.existUser(user);
    }

}
