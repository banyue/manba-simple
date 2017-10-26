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
}
