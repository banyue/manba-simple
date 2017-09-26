package com.manba.simple.domain.response;

import java.io.Serializable;

/**
 * 共用返回结果类
 * Created by lijin on 2017/9/26.
 */
public class ServiceResponse<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
