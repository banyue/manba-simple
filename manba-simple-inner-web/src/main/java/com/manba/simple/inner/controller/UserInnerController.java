package com.manba.simple.inner.controller;

import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.inner.api.InnerUserService;
import com.manba.simple.inner.domain.request.UserInnerRequest;
import com.manba.simple.inner.domain.response.UserInnerRespone;
import com.manba.simple.service.inner.UserInnerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户后台查询相关
 * Created by lijin on 2017/9/29.
 */
@RestController
@RequestMapping("/user")
public class UserInnerController {

    @Resource
    InnerUserService innerUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<PageBean<UserInnerRespone>> zoneList(UserInnerRequest request) {
        ServiceResponse<PageBean<UserInnerRespone>> response = innerUserService.queryUserList(request);
        return response;
    }
}
