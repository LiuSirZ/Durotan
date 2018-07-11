package com.zherke.template.service.impl;

import com.zherke.template.mapper.UsersMapper;
import com.zherke.template.pojo.Users;
import com.zherke.template.runner.ApplicationStartRunner;
import com.zherke.template.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwb
 * @create 2018-07-11 9:52
 * @desc 用户service实现
 **/
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users findByUser(Integer userId) {
        Users users = new Users();
        users.setId(userId);
        return usersMapper.selectOne(users);
    }
}
