package com.manba.simple.domain.request;

import io.swagger.annotations.ApiParam;

/**
 * 用户登录请求
 * Created by lijin on 2017/9/26.
 */
public class UserLoginRequest {

    @ApiParam(hidden = true)
    private String userId;

    private String username;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
