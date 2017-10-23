package com.manba.simple.upload.service;

import com.manba.simple.upload.domain.UploadRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by lijin on 2017/9/29.
 */
@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public String saveFile(UploadRequest request, InputStream stream, String uploadRootPath) {
        LOGGER.info("上传文件入参：{}", request.getAuthCode());
        //校验authCode

        //校验CRC

        //生成文件路径
        String md5 = DigestUtils.md5Hex(request.getAuthCode());
        StringBuilder sb = new StringBuilder();
        //sb.append(File.separator);
        sb.append(md5.substring(0,3)).append(File.separator)
                .append(md5.substring(3,6)).append(File.separator)
                .append(md5.substring(6,md5.length())).append(".")
                .append(request.getAuthCode().split("\\.")[1]);
        //保存文件
        try {
            String rootPath = uploadRootPath + File.separator + sb.toString();
            File newFile = new File(rootPath);
            if(!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            if(!newFile.exists()) {
                newFile.createNewFile();
            }
            FileOutputStream os = new FileOutputStream(rootPath);
            int b;
            while((b = stream.read()) != -1){ //读取文件
                os.write(b);
            }
            os.flush(); //关闭流
            stream.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("上传文件路径：{}", sb.toString());
        //返回路径
        return sb.toString();
    }

    public static void main(String args[]) {
        String path = "D:/abc.png";
        System.out.println(path.hashCode());

        String md5 = "9ba58cffe5815ea9f365b86a3f473ad5";
        StringBuilder sb = new StringBuilder();
        //sb.append(File.separator);
        sb.append(md5.substring(0,3)).append(File.separator)
                .append(md5.substring(3,6)).append(File.separator)
                .append(md5.substring(6,md5.length())).append(".")
                .append(("abc.png".split("\\."))[1]);
        System.out.println(sb.toString());

        System.out.println("abc.png".split("\\.").length);

        String imgPath = "9ba\\58c\\ffe5815ea9f365b86a3f473ad5.png";
        String paths[] = imgPath.split("\\\\");
        System.out.println(paths[paths.length - 1]);
    }

}
