package com.manba.simple.upload.domain;

import java.io.Serializable;

/**
 * Created by lijin on 2017/9/30.
 */
public class UploadRequest implements Serializable {

    private String authCode;
    private String keyCode;
    private String type;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
