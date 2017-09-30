package com.manba.simple.common.util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lijin on 2017/9/30.
 */
public class ImageUtils {

    public ImageUtils() {
    }

    public static byte[] fileToByte(File paramFile) {
        byte[] arrayOfByte = null;

        try {
            if(paramFile.exists()) {
                arrayOfByte = IOUtils.toByteArray(new BufferedInputStream(new FileInputStream(paramFile)));
            }
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return arrayOfByte;
    }

    public static byte[] getImgListByte(List<File> paramList) {
        byte[] arrayOfByte1 = null;

        try {
            int localException = 0;

            File j;
            for(Iterator localObject = paramList.iterator(); localObject.hasNext(); localException += fileToByte((File)j).length) {
                j = (File)localObject.next();
            }

            byte[] localObject1 = "#@*%!!".getBytes();
            arrayOfByte1 = new byte[paramList.size() * 6 + localException];
            int j1 = 0;

            int k;
            for(Iterator var5 = paramList.iterator(); var5.hasNext(); j1 += k) {
                File localFile = (File)var5.next();
                byte[] arrayOfByte2 = fileToByte(localFile);
                k = arrayOfByte2.length;
                System.arraycopy(localObject1, 0, arrayOfByte1, j1, 6);
                j1 += 6;
                System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j1, k);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return arrayOfByte1;
    }

    public static String bytesToHexString(byte[] paramArrayOfByte) {
        StringBuilder localStringBuilder = new StringBuilder();
        if(paramArrayOfByte != null && paramArrayOfByte.length > 0) {
            for(int i = 0; i < paramArrayOfByte.length; ++i) {
                int j = paramArrayOfByte[i] & 255;
                String str = Integer.toHexString(j);
                if(str.length() < 2) {
                    localStringBuilder.append(0);
                }

                localStringBuilder.append(str);
            }

            return localStringBuilder.toString();
        } else {
            return null;
        }
    }

    public boolean checkNewUri(String uri) {
        Pattern pattern = Pattern.compile("g(.+)/M[0-9]{2}/");
        Matcher matcher = pattern.matcher(uri);
        return matcher.find() && uri.startsWith("g");
    }
}
