package com.zherke.template.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zherke.template.bean.BaseResponseVo;
import com.zherke.template.mapper.UsersMapper;
import com.zherke.template.pojo.Users;
import com.zherke.template.service.UserService;
import com.zherke.template.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwb
 * @create 2018-07-11 9:52
 * @desc 用户service实现
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public BaseResponseVo findUserList(Integer userId) {

        PageHelper.startPage(0,10);
        List<Users> users = usersMapper.selectAll();
        return ResponseUtil.success(new PageInfo<Users>(users).getList());
    }

    @Override
    public BaseResponseVo findUserByMapper() {
        List<Users> users = usersMapper.findUserByMapper();
        return ResponseUtil.success(users);
    }

    @Override
    public BaseResponseVo findUserById(Integer userId) {
        Users user = usersMapper.findUserById(userId);
        return ResponseUtil.success(user);
    }
}
