package com.zherke.template.controller;

import com.zherke.template.pojo.Users;
import com.zherke.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lwb
 * @create 2018-07-11 9:55
 * @desc a demo for user controller
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public @ResponseBody ModelAndView test(Integer userId, ModelMap modelMap, ModelAndView modelAndView){
        Users users = userService.findByUser(userId);
        System.out.println(users);
        modelAndView.setViewName("index");
        return modelAndView;
    }



}
