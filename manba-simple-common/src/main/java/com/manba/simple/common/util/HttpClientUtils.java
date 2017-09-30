package com.manba.simple.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.*;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.CRC32;

/**
 * Created by lijin on 2017/9/30.
 */
public class HttpClientUtils {
    private static int conTimeout = 1000;
    private static int callTime = 10000;
    private static String IMAGE_POST_URL = "http://localhost:9090/upload/";
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public HttpClientUtils() {
    }

    public static void setImagePostUrl(String newUrl) {
        IMAGE_POST_URL = newUrl;
    }

    public static String fileUpload(File paramFile, String paramString) {
        String str = null;
        if (paramFile.exists()) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "imageUpload.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                //localException.setConnectionTimeout(conTimeout);
                //localException.setSoTimeout(callTime);
                localPostMethod.addRequestHeader("aucode", paramString);
                localPostMethod.addRequestHeader("type", "0");
                localPostMethod.addRequestHeader("keycode", Long.toHexString(FileUtils.checksumCRC32(paramFile)) + paramFile.length() + "_");
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(ImageUtils.fileToByte(paramFile)));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var10) {
                logger.error(paramString + "_" + paramFile.getName() + "_" + var10.getMessage(), var10);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getMsgStr("0", "5", paramFile.getAbsolutePath());
        }

        return str != null ? str : JsonUtils.getMsgStr("0", "10");
    }

    public static String fileUpload(List<File> paramList, String paramString) {
        String str1 = null;
        boolean i = true;
        CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
        if (paramList != null && paramList.size() > 0) {
            Iterator localObject2 = paramList.iterator();

            while (localObject2.hasNext()) {
                File localObject1 = (File) localObject2.next();
                if (!localObject1.exists()) {
                    localCopyOnWriteArrayList.add(new Message("0", "5", localObject1.getAbsolutePath()));
                    i = false;
                    break;
                }
            }

            if (i) {
                label141:
                {
                    HttpClient localObject11 = new HttpClient();
                    PostMethod localObject21 = new PostMethod(IMAGE_POST_URL + "imageUpload");

                    String var12;
                    try {
                        HttpConnectionManagerParams localException = ((HttpClient) localObject11).getHttpConnectionManager().getParams();
                        localException.setConnectionTimeout(conTimeout);
                        localException.setSoTimeout(callTime);
                        localObject21.addRequestHeader("aucode", paramString);
                        localObject21.addRequestHeader("type", "1");
                        StringBuilder localStringBuilder = new StringBuilder();
                        Iterator localObject3 = paramList.iterator();

                        while (localObject3.hasNext()) {
                            File j = (File) localObject3.next();
                            localStringBuilder.append(Long.toHexString(FileUtils.checksumCRC32((File) j)) + ((File) j).length() + "_");
                        }

                        ((PostMethod) localObject21).addRequestHeader("keycode", localStringBuilder.toString());
                        byte[] localObject31 = ImageUtils.getImgListByte(paramList);
                        ((PostMethod) localObject21).setRequestEntity(new ByteArrayRequestEntity((byte[]) ((byte[]) localObject31)));
                        int j1 = ((HttpClient) localObject11).executeMethod((HttpMethod) localObject21);
                        if (j1 != 200) {
                            logger.error("Method failed: " + ((PostMethod) localObject21).getStatusLine());
                        }

                        str1 = ((PostMethod) localObject21).getResponseBodyAsString();
                        String str2 = str1 != null ? str1 : JsonUtils.getMsgStr("0", "10");
                        var12 = str2;
                    } catch (Exception var16) {
                        logger.error(paramString + "_" + var16.getMessage(), var16);
                        break label141;
                    } finally {
                        localObject21.releaseConnection();
                        localObject11.getHttpConnectionManager().closeIdleConnections(0L);
                    }

                    return var12;
                }
            }
        } else {
            localCopyOnWriteArrayList.add(new Message("0", "5"));
        }

        str1 = JsonUtils.getMsgStr("0", localCopyOnWriteArrayList);
        return str1 != null ? str1 : JsonUtils.getMsgStr("0", "10");
    }

    public static String fileUpload(byte[] paramArrayOfByte, String paramString) {
        String str = null;
        if (paramArrayOfByte != null && paramArrayOfByte.length > 0) {
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(paramArrayOfByte));
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "imageUpload");

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

    public static String commonUpload(List<File> paramList, String paramString) {
        String str = null;
        if (paramList != null && paramList.size() > 0) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "commonUpload.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(20000);
                localException.setSoTimeout(20000);
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new StringPart("aucode", paramString));
                Iterator localObjects = paramList.iterator();

                while (localObjects.hasNext()) {
                    File localObject1 = (File) localObjects.next();
                    if (((File) localObject1).exists()) {
                        localArrayList.add(new FilePart("file", new FilePartSource(((File) localObject1).getName(), (File) localObject1)));
                    }
                }

                if (localArrayList != null && localArrayList.size() > 0) {
                    Part[] localObjects1 = new Part[localArrayList.size()];
                    localArrayList.toArray(localObjects1);
                    localPostMethod.setRequestEntity(new MultipartRequestEntity(localObjects1, localPostMethod.getParams()));
                    int i = localHttpClient.executeMethod(localPostMethod);
                    if (i != 200) {
                        logger.error("Method failed: " + localPostMethod.getStatusLine());
                    }

                    str = localPostMethod.getResponseBodyAsString();
                }
            } catch (Exception var13) {
                logger.error(paramString + "_" + var13.getMessage(), var13);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getMsgStr("0", "5");
        }

        return str != null ? str : JsonUtils.getMsgStr("0", "10");
    }

    public static String hardDelete(String uriList, String paramString) {
        String str = null;
        HttpClient localHttpClient = new HttpClient();
        PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "hardDelete.action");

        try {
            HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
            localException.setConnectionTimeout(conTimeout);
            localException.setSoTimeout(callTime);
            localPostMethod.addRequestHeader("aucode", paramString);
            localPostMethod.setRequestEntity(new StringRequestEntity(uriList));
            int i = localHttpClient.executeMethod(localPostMethod);
            if (i != 200) {
                logger.error("Method failed: " + localPostMethod.getStatusLine());
            }

            str = localPostMethod.getResponseBodyAsString();
        } catch (Exception var10) {
            logger.error(paramString + "_" + "_" + var10.getMessage(), var10);
        } finally {
            localPostMethod.releaseConnection();
            localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String softDelete(String uriList, String paramString) {
        String str = null;
        HttpClient localHttpClient = new HttpClient();
        PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "softDelete.action");

        try {
            HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
            localException.setConnectionTimeout(conTimeout);
            localException.setSoTimeout(callTime);
            localPostMethod.addRequestHeader("aucode", paramString);
            localPostMethod.setRequestEntity(new StringRequestEntity(uriList));
            int i = localHttpClient.executeMethod(localPostMethod);
            if (i != 200) {
                logger.error("Method failed: " + localPostMethod.getStatusLine());
            }

            str = localPostMethod.getResponseBodyAsString();
        } catch (Exception var10) {
            logger.error(paramString + "_" + "_" + var10.getMessage(), var10);
        } finally {
            localPostMethod.releaseConnection();
            localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String cancelSoftDelete(String uriList, String paramString) {
        String str = null;
        HttpClient localHttpClient = new HttpClient();
        PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "cancelSoftDelete.action");

        try {
            HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
            localException.setConnectionTimeout(conTimeout);
            localException.setSoTimeout(callTime);
            localPostMethod.addRequestHeader("aucode", paramString);
            localPostMethod.setRequestEntity(new StringRequestEntity(uriList));
            int i = localHttpClient.executeMethod(localPostMethod);
            if (i != 200) {
                logger.error("Method failed: " + localPostMethod.getStatusLine());
            }

            str = localPostMethod.getResponseBodyAsString();
        } catch (Exception var10) {
            logger.error(paramString + "_" + "_" + var10.getMessage(), var10);
        } finally {
            localPostMethod.releaseConnection();
            localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String replaceDelete(byte[] newBody, String aucode, String oldUri) {
        String str = null;
        if (newBody != null && newBody.length != 0) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "replaceDelete.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(conTimeout);
                localException.setSoTimeout(callTime);
                localPostMethod.addRequestHeader("aucode", aucode);
                localPostMethod.addRequestHeader("type", "0");
                localPostMethod.addRequestHeader("oldUri", oldUri);
                CRC32 crc32 = new CRC32();
                crc32.update(newBody);
                localPostMethod.addRequestHeader("keycode", Long.toHexString(crc32.getValue()) + newBody.length + "_");
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(newBody));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var12) {
                logger.error(aucode + "_" + var12.getMessage(), var12);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getDeleteMsgStr("0", "5");
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String replaceDelete(File paramFile, String paramString, String oldUri) {
        String str = null;
        if (paramFile.exists()) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "replaceDelete.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(conTimeout);
                localException.setSoTimeout(callTime);
                localPostMethod.addRequestHeader("aucode", paramString);
                localPostMethod.addRequestHeader("type", "0");
                localPostMethod.addRequestHeader("oldUri", oldUri);
                localPostMethod.addRequestHeader("keycode", Long.toHexString(FileUtils.checksumCRC32(paramFile)) + paramFile.length() + "_");
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(ImageUtils.fileToByte(paramFile)));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var11) {
                logger.error(paramString + "_" + paramFile.getName() + "_" + var11.getMessage(), var11);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getDeleteMsgStr("0", "5");
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String otherUpload(File paramFile, String paramString) {
        String str = null;
        if (paramFile.exists()) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "otherUpload.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(conTimeout);
                localException.setSoTimeout(callTime);
                String fileName = paramFile.getName();
                localPostMethod.addRequestHeader("aucode", paramString);
                localPostMethod.addRequestHeader("fileName", fileName);
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(ImageUtils.fileToByte(paramFile)));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var11) {
                logger.error(paramString + "_" + paramFile.getName() + "_" + var11.getMessage(), var11);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getMsgStr("0", "5", paramFile.getAbsolutePath());
        }

        return str != null ? str : JsonUtils.getMsgStr("0", "10");
    }

    public static String otherDelete(String uriList, String paramString) {
        String str = null;
        HttpClient localHttpClient = new HttpClient();
        PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "otherDelete.action");

        try {
            HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
            localException.setConnectionTimeout(conTimeout);
            localException.setSoTimeout(callTime);
            localPostMethod.addRequestHeader("aucode", paramString);
            localPostMethod.setRequestEntity(new StringRequestEntity(uriList));
            int i = localHttpClient.executeMethod(localPostMethod);
            if (i != 200) {
                logger.error("Method failed: " + localPostMethod.getStatusLine());
            }

            str = localPostMethod.getResponseBodyAsString();
        } catch (Exception var10) {
            logger.error(paramString + "_" + "_" + var10.getMessage(), var10);
        } finally {
            localPostMethod.releaseConnection();
            localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static String otherReplace(File paramFile, String paramString, String oldUri) {
        String str = null;
        if (paramFile.exists()) {
            HttpClient localHttpClient = new HttpClient();
            PostMethod localPostMethod = new PostMethod(IMAGE_POST_URL + "otherReplace.action");

            try {
                HttpConnectionManagerParams localException = localHttpClient.getHttpConnectionManager().getParams();
                localException.setConnectionTimeout(conTimeout);
                localException.setSoTimeout(callTime);
                String fileName = paramFile.getName();
                localPostMethod.addRequestHeader("fileName", fileName);
                localPostMethod.addRequestHeader("aucode", paramString);
                localPostMethod.addRequestHeader("oldUri", oldUri);
                localPostMethod.setRequestEntity(new ByteArrayRequestEntity(ImageUtils.fileToByte(paramFile)));
                int i = localHttpClient.executeMethod(localPostMethod);
                if (i != 200) {
                    logger.error("Method failed: " + localPostMethod.getStatusLine());
                }

                str = localPostMethod.getResponseBodyAsString();
            } catch (Exception var12) {
                logger.error(paramString + "_" + paramFile.getName() + "_" + var12.getMessage(), var12);
            } finally {
                localPostMethod.releaseConnection();
                localHttpClient.getHttpConnectionManager().closeIdleConnections(0L);
            }
        } else {
            str = JsonUtils.getDeleteMsgStr("0", "5");
        }

        return str != null ? str : JsonUtils.getDeleteMsgStr("0", "10");
    }

    public static void setConTimeout(int conTimeout) {
        HttpClientUtils.conTimeout = conTimeout;
    }

    public static void setCallTime(int callTime) {
        HttpClientUtils.callTime = callTime;
    }

    public static void main(String[] paramArrayOfString) throws IOException {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new File("E:\\img\\img2\\111.png"));
        conTimeout = '썐';
        localArrayList.add(new File("E:\\img\\img2\\222.png"));
        System.out.println("xixi========xixi");
        System.out.println(otherDelete("g2/M00/00/01/CgrhNlEKLTkIAAAAAAAHLIP8hUEAAAAnACDSjQAAAdE004.txt", "cdfe9fe70df78042b009ed20d50da0ad"));
    }
}
