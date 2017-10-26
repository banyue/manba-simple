package com.manba.simple.common.util;

/**
 * Created by lijin on 2017/9/30.
 */
public class ImageUpload {

    private static int conTimeout = 1000;
    private static int callTime = 10000;

    public ImageUpload() {
    }

    public static String uploadFile(byte[] paramArrayOfByte, String paramString, String uploadPath) throws Exception {
        //setTimeout();
        String str = HttpClientUtils.fileUpload(paramArrayOfByte, paramString, uploadPath);
        return str;
    }

    public static void setTimeout() {
        HttpClientUtils.setCallTime(callTime);
        HttpClientUtils.setConTimeout(conTimeout);
    }

    public static void setConTimeout(int conTimeout) {
        ImageUpload.conTimeout = conTimeout;
    }
}
