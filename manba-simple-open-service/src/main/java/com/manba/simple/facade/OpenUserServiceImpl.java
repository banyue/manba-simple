package com.manba.simple.facade;

import com.alibaba.fastjson.JSON;
import com.manba.simple.api.OpenUserService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.exception.BaseMsgException;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.request.UpdatePasswordRequest;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户对外接口实现
 * Created by lijin on 2017/9/27.
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenUserServiceImpl.class);

    @Resource
    UserService userService;

    @Override
    public ServiceResponse<UserInfoResponse> userLogin(UserLoginRequest request) {
        LOGGER.info("用户登录入参：{}", JSON.toJSONString(request));
        ServiceResponse<UserInfoResponse> response = new ServiceResponse<UserInfoResponse>();
        try {
            ManSimpleUserEntity entity = new ManSimpleUserEntity();
            entity.setPhone(request.getPhone());
            entity.setPassword(request.getPassword());
            ManSimpleUserEntity one = userService.getOneUserInfo(entity);
            if(null == one) {
                //用户不存在
                return new ServiceResponse<UserInfoResponse>(BaseResponseCode.USER_NOT_EXIST);
            }
            if(one.getPassword().equals(request.getPassword())) {
                //密码错误
                return new ServiceResponse<UserInfoResponse>(BaseResponseCode.PASSWORD_ERROR);
            }
            UserInfoResponse userInfo = new UserInfoResponse();
            userInfo.setUserId(entity.getId());
            userInfo.setPhotoUrl(entity.getPhotoUrl());
            userInfo.setNickName(entity.getNickName());
            userInfo.setPhone(entity.getPhone());
            response.isSuccess();
            response.setResult(userInfo);
            response.setCode(BaseResponseCode.SUCCESS.getCode());
            response.setMsg(BaseResponseCode.SUCCESS.getMsg());
        } catch (BaseMsgException msg) {
            LOGGER.error("用户登录业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<UserInfoResponse>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("用户登录异常！{}", e);
            return new ServiceResponse<UserInfoResponse>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("用户登录出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> userRegister(UserRequest request) {
        LOGGER.info("用户注册入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        ManSimpleUserEntity entity = new ManSimpleUserEntity();
        try {
            //参数校验
            Map<String, Object> param = registerParamMap(request);
            String checkInfo = StringUtil.checkEmpty(param);
            if (!StringUtil.isEmpty(checkInfo)) {
                BaseResponseCode.PARAM_ERROR.setMsg(checkInfo);
                return new ServiceResponse<Long>(BaseResponseCode.PARAM_ERROR);
            }
            entity.setPhone(request.getPhone());
            entity.setPassword(request.getPassword());
            entity.setSex(request.getSex());
            entity.setNickName(request.getNickName());
            entity.setInteresting(request.getInteresting());
            entity.setCreateTime(new Date());
            Long id = userService.createUser(entity);
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("用户注册业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("用户注册异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("用户注册出参：{}", JSON.toJSONString(response));
        return response;
    }

    private Map<String, Object> registerParamMap(UserRequest request) {
        if(null == request) {
            return null;
        }
        Map<String, Object> param = new HashMap<>(2);
        param.put("phone", request.getPhone());
        param.put("password", request.getPassword());
        return param;
    }

    @Override
    public ServiceResponse<Integer> updatePassword(UpdatePasswordRequest request) {
        LOGGER.info("更新密码入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            ManSimpleUserEntity entity = new ManSimpleUserEntity();
            entity.setId(Long.valueOf(request.getUserId()));
            entity.setPassword(request.getNewPassword());
            entity.setUpdateTime(new Date());
            Integer id = userService.updateUserInfo(entity);
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("更新密码业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("更新密码异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("更新密码出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<String> uploadPhoto(UserRequest request) {
        //保存到用户表，同时保存到相册表
        LOGGER.info("上传头像入参：{}", JSON.toJSONString(request));
        ServiceResponse<String> response = new ServiceResponse<String>();
        try {
            ManSimpleUserEntity entity = new ManSimpleUserEntity();
            entity.setId(Long.valueOf(request.getUserId()));
            entity.setPhotoUrl(request.getPhotoUrl());
            entity.setUpdateTime(new Date());
            userService.uploadPhotoAndSaveAlbum(entity);
            response.setResult(request.getPhotoUrl());
        } catch (BaseMsgException msg) {
            LOGGER.error("上传头像业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<String>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("上传头像异常！{}", e);
            return new ServiceResponse<String>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("上传头像出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
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
