package com.ssm.dao;

import com.ssm.pojo.User;

/**
 * @program: netdisc
 * @description:用户持久
 * @author: Mr.Gu
 * @create: 2020-06-15 17:02
 **/
public interface UserDao {
    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 是否存在
     * @param user
     * @return
     */
    int existUser(User user);
}
