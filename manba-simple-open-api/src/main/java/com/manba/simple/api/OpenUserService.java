package com.manba.simple.api;

import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.domain.request.UpdatePasswordRequest;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRequest;
import com.manba.simple.domain.response.UserInfoResponse;

/**
 * 用户相关对外服务接口
 * Created by lijin on 2017/9/26.
 */
public interface OpenUserService {

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    ServiceResponse<UserInfoResponse> userLogin(UserLoginRequest request);

    /**
     * 用户注册
     * @param request
     * @return
     */
    ServiceResponse<Long> userRegister(UserRequest request);

    /**
     * 修改密码
     * @param request
     * @return
     */
    ServiceResponse<Integer> updatePassword(UpdatePasswordRequest request);

    /**
     * 上传头像
     * @param request
     * @return
     */
    ServiceResponse<String> uploadPhoto(UserRequest request);

    /**
     * 查询用户详情
     * @param request
     * @return
     */
    ServiceResponse<UserInfoResponse> queryUserInfo(UserLoginRequest request);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    ServiceResponse<UserInfoResponse> queryUserInfoByPhone(String phone);
}
