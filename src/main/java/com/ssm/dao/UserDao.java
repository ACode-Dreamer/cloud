package com.ssm.dao;

import com.ssm.pojo.User;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 17:02
 **/
public interface UserDao {
    int register(User user);
    User login(User user);
    int existUser(User user);
}
