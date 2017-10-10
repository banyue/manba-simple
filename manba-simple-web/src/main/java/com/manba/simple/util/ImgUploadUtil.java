package com.manba.simple.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.manba.simple.common.util.ImageUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lijin on 2017/9/30.
 */
public class ImgUploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImgUploadUtil.class);
    //图片上传路径
    private static final String IMG_BASE_URL = "http://localhost:9090/upload/";

    /**
     * 上传图片
     * @param imgFile
     * @return 返回图片地址
     */
    public static String uploadImg(MultipartFile imgFile) {
        if(imgFile == null || imgFile.getSize() == 0){
            return null;
        }
        String res = null;
        try {
            String uploadResponse = ImageUpload.uploadFile(imgFile.getBytes(), imgFile.getOriginalFilename());
            LOGGER.info("返回结果：{}", uploadResponse);
            JSONObject jsonObject = JSON.parseArray("[" + uploadResponse + "]").getJSONObject(0);
            if(!"1".equals(jsonObject.get("id"))){//异常
                LOGGER.info("文件上传异常！{}", uploadResponse);
            } else {
                res = jsonObject.get("msg").toString();
                LOGGER.info("文件上传完毕！{}", res);
            }
        } catch (Exception e) {
            LOGGER.error("上传图片失败", e);
        }
        return IMG_BASE_URL + res;
    }
}
