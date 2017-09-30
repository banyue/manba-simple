package com.manba.simple.common.util;

/**
 * Created by lijin on 2017/9/30.
 */
public class DeleteMessage {

    private String id;
    private String msg;
    private String oldUri;

    public DeleteMessage(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public DeleteMessage(String id, String msg, String oldUri) {
        this.id = id;
        this.msg = msg;
        this.oldUri = oldUri;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOldUri() {
        return this.oldUri;
    }

    public void setOldUri(String oldUri) {
        this.oldUri = oldUri;
    }
}
