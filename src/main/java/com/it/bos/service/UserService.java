package com.it.bos.service;

import com.it.bos.pojo.TUser;

/**
 * Created by Think on 2018/5/7.
 */
public interface UserService {
    TUser userLoginByUsernameAndPassword(String username, String password);

    TUser findByUsername(String username);
}
