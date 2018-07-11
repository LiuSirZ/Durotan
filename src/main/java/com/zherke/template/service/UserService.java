package com.zherke.template.service;

import com.zherke.template.pojo.Users;
import org.springframework.stereotype.Service;

/**
 * @author lwb
 * @create 2018-07-11 9:51
 * @desc 用户service
 **/
public interface UserService {

    Users findByUser(Integer userId);
}
