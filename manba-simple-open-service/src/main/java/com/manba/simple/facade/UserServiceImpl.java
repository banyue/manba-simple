package com.manba.simple.facade;

import com.manba.simple.api.UserService;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRegisterRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import org.springframework.stereotype.Service;

/**
 * 用户对外接口实现
 * Created by lijin on 2017/9/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ServiceResponse<Boolean> userLogin(UserLoginRequest request) {
        return null;
    }

    @Override
    public ServiceResponse<Boolean> userRegister(UserRegisterRequest request) {
        return null;
    }

    @Override
    public ServiceResponse<Boolean> updatePassword(UserLoginRequest request) {
        return null;
    }

    @Override
    public ServiceResponse<String> uploadPhoto(UserLoginRequest request) {
        return null;
    }

    @Override
    public ServiceResponse<UserInfoResponse> queryUserInfo(UserLoginRequest request) {
        return null;
    }
}
