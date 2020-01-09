package com.danny.blog.service.service;

import com.danny.blog.entity.User;

/**
 * Created by Danny on 2019/2/13
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User selectByUserName(String userName);

    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    int updateByUserId(User user);
}
