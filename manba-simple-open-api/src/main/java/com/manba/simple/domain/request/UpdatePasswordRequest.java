package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/23.
 * 更新密码请求
 */
public class UpdatePasswordRequest implements Serializable {

    private String newPassword;
    private String userId;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
