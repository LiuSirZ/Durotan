package com.zherke.controller;

import lombok.extern.slf4j.Slf4j;
import com.zherke.bean.BaseResponseVo;
import com.zherke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/hello/test")
    public BaseResponseVo test(Integer userId){
        return userService.findUserList(userId);
    }

    @GetMapping("/hello/find")
    public BaseResponseVo findUserByMapper(){
        return userService.findUserByMapper();
    }

    @PostMapping("/hello/findById")
    public BaseResponseVo findById(Integer userId){
        return userService.findUserById(userId);
    }

}
