package com.manba.simple.facade;

import com.manba.simple.api.OpenUserService;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRegisterRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户对外接口实现
 * Created by lijin on 2017/9/27.
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {

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
        ServiceResponse<UserInfoResponse> response = new ServiceResponse<UserInfoResponse>();
        ManSimpleUserEntity entity = new ManSimpleUserEntity();
        entity.setId(Long.valueOf(request.getUserId()));
        ManSimpleUserEntity result = userService.getOneUserInfo(entity);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setNickName(result.getNickName());
        userInfoResponse.setPhone(result.getPhone());
        userInfoResponse.setPhotoUrl(result.getPhotoUrl());
        userInfoResponse.setUserId(result.getId());
        response.setResult(userInfoResponse);
        return response;
    }
}
