package com.zherke.template.controller;

import com.zherke.template.bean.BaseResponseVo;
import com.zherke.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwb
 * @create 2018-07-11 9:55
 * @desc a demo for user controller
 **/
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello/test")
    public BaseResponseVo test(Integer userId){
        return userService.findUserList(userId);
    }



}
