package com.manba.simple.controller;

import com.manba.simple.api.OpenUserService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.request.UpdatePasswordRequest;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.request.UserRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.util.ImgUploadUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 用户相关操作网关
 * Created by lijin on 2017/9/27.
 */
@RestController
@RequestMapping
@Api("用户相关API")
public class UserController {

    @Value("${image.upload.post.url}")
    private String IMAGE_UPLOAD_URL;

    @Resource
    private OpenUserService openUserService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ServiceResponse<UserInfoResponse> getUser(@PathVariable String id, Model model) {
        UserLoginRequest request = new UserLoginRequest();
        request.setUserId(id);
        ServiceResponse<UserInfoResponse> response = openUserService.queryUserInfo(request);
        return response;
    }

    @ApiOperation("上传用户头像")
    @RequestMapping(value = "/uploadPhoto/{id}", method = RequestMethod.POST)
    public ServiceResponse<String> uploadPhoto(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        UserRequest request = new UserRequest();
        ServiceResponse<String> response = new ServiceResponse<String>();
        request.setUserId(Long.valueOf(id));
        try {
            String path = ImgUploadUtil.uploadImg(file, IMAGE_UPLOAD_URL);
            if(StringUtil.isEmpty(path)) {
                request.setPhotoUrl(path);
                response = openUserService.uploadPhoto(request);
            } else {
                return new ServiceResponse<String>(BaseResponseCode.FAILURE);
            }
        } catch (Exception e) {
            return new ServiceResponse<String>(BaseResponseCode.FAILURE);
        }
        return response;
    }

    @ApiOperation("注册用户")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ServiceResponse<Long> register(UserRequest request) {
        ServiceResponse<Long> response = openUserService.userRegister(request);
        return response;
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServiceResponse<UserInfoResponse> login(UserLoginRequest request) {
        ServiceResponse<UserInfoResponse> response = openUserService.userLogin(request);
        return response;
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    public ServiceResponse<Integer> updatePassword(UpdatePasswordRequest request) {
        ServiceResponse<Integer> response = openUserService.updatePassword(request);
        return response;
    }
}
