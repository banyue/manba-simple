package com.manba.simple.upload.controller;

import com.manba.simple.common.util.Message;
import com.manba.simple.upload.domain.UploadRequest;
import com.manba.simple.upload.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
}
