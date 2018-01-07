package com.hdu.train.service;

import com.hdu.train.pojo.User;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:46 18-1-7
 * @Modified By:
 */
public interface UserService {
    User checkLogin(User user) throws Exception;
}
