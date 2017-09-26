package com.manba.simple.api;

import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRegisterRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.sun.deploy.services.Service;

/**
 * 用户相关对外服务接口
 * Created by lijin on 2017/9/26.
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    ServiceResponse<Boolean> userLogin(UserLoginRequest request);

    /**
     * 用户注册
     * @param request
     * @return
     */
    ServiceResponse<Boolean> userRegister(UserRegisterRequest request);

    /**
     * 修改密码
     * @param request
     * @return
     */
    ServiceResponse<Boolean> updatePassword(UserLoginRequest request);

    /**
     * 上传头像
     * @param request
     * @return
     */
    ServiceResponse<String> uploadPhoto(UserLoginRequest request);

    /**
     * 查询用户详情
     * @param request
     * @return
     */
    ServiceResponse<UserInfoResponse> queryUserInfo(UserLoginRequest request);
}
