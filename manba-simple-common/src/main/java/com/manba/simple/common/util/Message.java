package com.manba.simple.common.util;

/**
 * Created by lijin on 2017/9/30.
 */
public class Message {

    private String id;
    private String msg;
    private String remark;

    public Message() {
    }

    public Message(String paramString1, String paramString2) {
        this.id = paramString1;
        this.msg = paramString2;
    }

    public Message(String paramString1, String paramString2, String paramString3) {
        this.id = paramString1;
        this.msg = paramString2;
        this.remark = paramString3;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String paramString) {
        this.remark = paramString;
    }
}
