package com.manba.simple.common.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

/**
 * Created by lijin on 2017/9/30.
 */
public class CRC32Util {
    public CRC32Util() {
    }

    public static String getFileCRCCode(InputStream paramInputStream) {
        CRC32 localCRC32 = new CRC32();

        try {
            BufferedInputStream localException = new BufferedInputStream(paramInputStream);
            CheckedInputStream localCheckedInputStream = new CheckedInputStream(localException, localCRC32);

            while(true) {
                if(localCheckedInputStream.read() != -1) {
                    continue;
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return Long.toHexString(localCRC32.getValue());
    }
}
