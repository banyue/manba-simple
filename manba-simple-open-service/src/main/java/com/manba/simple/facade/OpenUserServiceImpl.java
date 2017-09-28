package com.manba.simple.facade;

import com.alibaba.fastjson.JSON;
import com.manba.simple.api.OpenUserService;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRegisterRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户对外接口实现
 * Created by lijin on 2017/9/27.
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenUserServiceImpl.class);

    @Resource
    UserService userService;

    public ServiceResponse<Boolean> userLogin(UserLoginRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> userRegister(UserRegisterRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> updatePassword(UserLoginRequest request) {
        return null;
    }

    public ServiceResponse<String> uploadPhoto(UserLoginRequest request) {
        return null;
    }

    public ServiceResponse<UserInfoResponse> queryUserInfo(UserLoginRequest request) {
        LOGGER.info("查询用户信息入参：{}", JSON.toJSONString(request));
        ServiceResponse<UserInfoResponse> response = new ServiceResponse<UserInfoResponse>();
        try {
            ManSimpleUserEntity entity = new ManSimpleUserEntity();
            entity.setId(Long.valueOf(request.getUserId()));
            ManSimpleUserEntity result = userService.getOneUserInfo(entity);
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            userInfoResponse.setNickName(result.getNickName());
            userInfoResponse.setPhone(result.getPhone());
            userInfoResponse.setPhotoUrl(result.getPhotoUrl());
            userInfoResponse.setUserId(result.getId());
            response.setResult(userInfoResponse);
        } catch (Exception e) {

        }
        LOGGER.info("查询用户信息出参：{}", JSON.toJSONString(response));
        return response;
    }
}
