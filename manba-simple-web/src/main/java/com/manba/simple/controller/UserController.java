package com.manba.simple.controller;

import com.manba.simple.api.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关操作网关
 * Created by lijin on 2017/9/27.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
