package com.manba.simple.common.util;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijin on 2017/9/30.
 */
public class ImageUpload {

    private static int conTimeout = 1000;
    private static int callTime = 10000;

    public ImageUpload() {
    }

    public static String uploadFile(List<File> paramList, String paramString) throws Exception {
        setTimeout();
        String str = HttpClientUtils.fileUpload(paramList, paramString);
        return str;
    }

    public static void setUploadUrl(String newUrl) {
        HttpClientUtils.setImagePostUrl(newUrl);
    }

    public static String uploadFile(File paramFile, String paramString) throws Exception {
        setTimeout();
        String str = HttpClientUtils.fileUpload(paramFile, paramString);
        return str;
    }

    public static String uploadFile(byte[] paramArrayOfByte, String paramString) throws Exception {
        //setTimeout();
        String str = HttpClientUtils.fileUpload(paramArrayOfByte, paramString);
        return str;
    }

    public static String commonUpload(List<File> paramList, String paramString) throws Exception {
        setTimeout();
        String str = HttpClientUtils.commonUpload(paramList, paramString);
        return str;
    }

    public static String urlUpload(String imgUrl, String paramString) throws Exception {
        setTimeout();
        URL URL = new URL(imgUrl);
        HttpURLConnection connection = (HttpURLConnection)URL.openConnection();
        byte[] arrayOfByte = (byte[])null;
        arrayOfByte = IOUtils.toByteArray(new BufferedInputStream(connection.getInputStream()));
        String str = HttpClientUtils.fileUpload(arrayOfByte, paramString);
        return str;
    }

    public static void setTimeout() {
        HttpClientUtils.setCallTime(callTime);
        HttpClientUtils.setConTimeout(conTimeout);
    }

    public static void setConTimeout(int conTimeout) {
        ImageUpload.conTimeout = conTimeout;
    }

    public static void setCallTime(int callTime) {
        ImageUpload.callTime = callTime;
    }

    public static void main(String[] paramArrayOfString) {
        try {
            ArrayList localException = new ArrayList();
            boolean i = false;

            String str;
            for(int var5 = 1; var5 < 8; ++var5) {
                str = "/root/" + String.valueOf(var5) + ".jpg";
                localException.add(new File(str));
            }

            str = uploadFile((List)localException, "f93acff9049af04bad0b11f0d13903d1");
            System.out.println(str);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
