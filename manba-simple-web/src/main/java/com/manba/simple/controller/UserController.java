package com.manba.simple.controller;

import com.manba.simple.api.OpenUserService;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关操作网关
 * Created by lijin on 2017/9/27.
 */
@RestController
@RequestMapping
public class UserController {

    @Resource
    private OpenUserService userService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ServiceResponse<UserInfoResponse> getUser(@PathVariable String id, Model model) {
        UserLoginRequest request = new UserLoginRequest();
        request.setUserId(id);
        ServiceResponse<UserInfoResponse> response = userService.queryUserInfo(request);
        return response;
    }


}
