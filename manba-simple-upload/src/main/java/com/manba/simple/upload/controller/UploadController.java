package com.manba.simple.upload.controller;

import com.manba.simple.common.util.Message;
import com.manba.simple.upload.domain.UploadRequest;
import com.manba.simple.upload.service.UploadService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lijin on 2017/9/29.
 */
@RestController
@RequestMapping
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Value("${upload.image.root.path}")
    private String uploadRootPath;

    @Resource
    UploadService uploadService;

    @ApiOperation("上传图片图片")
    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    public Message imageUpload(HttpServletRequest request) {
        Message message = new Message();
        UploadRequest uploadRequest = new UploadRequest();
        uploadRequest.setAuthCode(request.getHeader("authCode"));  //原始名称
        uploadRequest.setKeyCode(request.getHeader("keyCode"));
        uploadRequest.setType(request.getHeader("type"));
        String path = "";
        try {
            path = uploadService.saveFile(uploadRequest, request.getInputStream(), uploadRootPath);
        } catch (Exception e) {
            LOGGER.info("文件流读取失败！");
        }
        message.setId("1");
        message.setRemark("成功");
        if("".equals(path)) {
            message.setId("0");
            message.setRemark("失败");
        }
        message.setMsg(path);
        return message;
    }

    @ApiOperation("加载图片")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, String path) {
        String paths[] = path.split("\\\\");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + paths[paths.length - 1] + "\"");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(uploadRootPath + path));
            bos = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[2048];
            int bytesRead;

            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bos.flush();
        } catch (final IOException e) {
            System.out.println("IOException." + e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    System.out.println("IOException." + e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.out.println("IOException." + e);
                }
            }
        }
    }
}
