package com.manba.simple.common.util;

import com.alibaba.fastjson.JSON;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lijin on 2017/9/30.
 */
public class JsonUtils {

    public JsonUtils() {
    }

    public static String getMsgStr(String paramString1, String paramString2) {
        String str = JSON.toJSONString(new Message(paramString1, paramString2));
        return str;
    }

    public static String getMsgStr(String paramString1, String paramString2, String paramString3) {
        String str = JSON.toJSONString(new Message(paramString1, paramString2, paramString3));
        return str;
    }

    public static String getMsgStr(String paramString, List<Message> paramList) {
        String str = "";

        Message m;
        for(Iterator var3 = paramList.iterator(); var3.hasNext(); str = str + JSON.toJSONString(m)) {
            m = (Message)var3.next();
        }

        return str;
    }

    public static String getDeleteMsgStr(String paramString1, String paramString2) {
        String str = JSON.toJSONString(new Message(paramString1, paramString2));
        return str;
    }

    public static String getDeleteMsgStr(String paramString, List<DeleteMessage> paramList) {
        String str = "";

        DeleteMessage m;
        for(Iterator var3 = paramList.iterator(); var3.hasNext(); str = str + JSON.toJSONString(m)) {
            m = (DeleteMessage)var3.next();
        }

        return str;
    }
}
