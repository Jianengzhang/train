package com.hdu.train.dao;

import com.hdu.train.pojo.User;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:43 18-1-7
 * @Modified By:
 */
public interface UserDao {
    //通过用户名获取用户信息
    User findUserByUserName(String userName);
}
