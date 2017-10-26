package com.manba.simple.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

/**
 * Created by lijin on 2017/9/30.
 */
public class HttpClientUtils {
    private static int conTimeout = 1000;
    private static int callTime = 10000;
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public HttpClientUtils() {
    }

    public static String fileUpload(byte[] paramArrayOfByte, String paramString, String uploadPath) {
        String str = null;
        if (paramArrayOfByte != null && paramArrayOfByte.length > 0) {
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(paramArrayOfByte));
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(uploadPath + "imageUpload");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(conTimeout);
                localException.setSoTimeout(callTime);
                localPostMethod.addRequestHeader("authCode", paramString);
                localPostMethod.addRequestHeader("type", "2");
                //localPostMethod.addRequestHeader("keyCode", CRC32Util.getFileCRCCode(localBufferedInputStream) + paramArrayOfByte.length);
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(paramArrayOfByte));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var11) {
                logger.error(paramString + "_" + var11.getMessage(), var11);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getMsgStr("0", "5");
        }

        return str != null ? str : JsonUtils.getMsgStr("0", "10");
    }

    public static void setConTimeout(int conTimeout) {
        HttpClientUtils.conTimeout = conTimeout;
    }

    public static void setCallTime(int callTime) {
        HttpClientUtils.callTime = callTime;
    }

}
