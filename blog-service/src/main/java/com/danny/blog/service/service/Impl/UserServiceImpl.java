package com.danny.blog.service.service.Impl;

import com.danny.blog.dao.UserMapper;
import com.danny.blog.entity.User;
import com.danny.blog.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Danny on 2019/2/13
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    @Override
    public int updateByUserId(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
