package com.zherke.template.service;

import com.zherke.template.bean.BaseResponseVo;
import com.zherke.template.pojo.Users;

/**
 * @author lwb
 * @create 2018-07-11 9:51
 * @desc 用户service
 **/
public interface UserService {

    Users findByUser(Integer userId);

    BaseResponseVo findUserList(Integer userId);
}
