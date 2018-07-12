package com.zherke.template.controller;

import com.zherke.template.pojo.Users;
import com.zherke.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwb
 * @create 2018-07-11 9:55
 * @desc a demo for user controller
 **/
@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ModelMap test(Integer userId,ModelMap modelMap){
        Users users = userService.findByUser(userId);
        log.info(users.toString());
        modelMap.put("user",users);
        return modelMap;
    }



}
