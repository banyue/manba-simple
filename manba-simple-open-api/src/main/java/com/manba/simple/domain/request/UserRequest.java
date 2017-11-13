package com.manba.simple.domain.request;

import io.swagger.annotations.ApiParam;

/**
 * 用户注册请求
 * Created by lijin on 2017/9/26.
 */
public class UserRequest {

    @ApiParam(hidden = true)
    private Long userId;

    private String phone;

    private String password;

    private String nickName;

    private Integer sex;

    private String interesting;

    @ApiParam(hidden = true)
    private String photoUrl;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
