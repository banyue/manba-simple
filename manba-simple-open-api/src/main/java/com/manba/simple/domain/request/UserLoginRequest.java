package com.manba.simple.domain.request;

/**
 * 用户登录请求
 * Created by lijin on 2017/9/26.
 */
public class UserLoginRequest {

    private String userId;

    private String phone;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
