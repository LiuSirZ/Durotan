package com.zherke.template.service;

import com.zherke.template.bean.BaseResponseVo;

/**
 * @author lwb
 * @create 2018-07-11 9:51
 * @desc 用户service
 **/
public interface UserService {

    BaseResponseVo findUserList(Integer userId);

    BaseResponseVo findUserByMapper();

    BaseResponseVo findUserById(Integer userId);
}
