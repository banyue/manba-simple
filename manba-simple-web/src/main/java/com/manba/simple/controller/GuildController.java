package com.manba.simple.controller;

import com.manba.simple.api.OpenGuildService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.request.GuildUserRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.util.ImgUploadUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 公会相关网关接口
 * Created by lijin on 2017/9/28.
 */
@RestController
@RequestMapping("/guild")
public class GuildController {

    @Value("${image.upload.post.url}")
    private String IMAGE_UPLOAD_URL;

    @Resource
    OpenGuildService openGuildService;

    @ApiOperation("获取公会列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<PageBean<GuildResponse>> guildList(GuildRequest request) {
        ServiceResponse<PageBean<GuildResponse>> response = openGuildService.queryGuildList(request);
        return response;
    }

    @ApiOperation("查询公会详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ServiceResponse<GuildResponse> guildDetail(@PathVariable String id) {
        GuildRequest request = new GuildRequest();
        request.setGuildId(id);
        ServiceResponse<GuildResponse> response = openGuildService.getGuildInfo(request);
        return response;
    }

    @ApiOperation("创建公会")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ServiceResponse<Long> createGuild(CreateGuildRequest request) {
        //保存头像
        String path;
        if(null != request.getPhotoFile()) {
            path = ImgUploadUtil.uploadImg(request.getPhotoFile(), IMAGE_UPLOAD_URL);
            if (StringUtil.isEmpty(path)) {
                request.setGuildPhoto(path);
            } else {
                BaseResponseCode.FAILURE.setMsg("上传头像失败！");
                return new ServiceResponse<Long>(BaseResponseCode.FAILURE);
            }
        }
        ServiceResponse<Long> response = openGuildService.createGuild(request);
        return response;
    }

    @ApiOperation("退出公会")
    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    public ServiceResponse<Integer> quitGuild(GuildUserRequest request) {
        ServiceResponse<Integer> response = openGuildService.quitGuild(request);
        return response;
    }

    @ApiOperation("加入公会")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ServiceResponse<Long> addGuild(GuildUserRequest request) {
        ServiceResponse<Long> response = openGuildService.addGuild(request);
        return response;
    }

    @ApiOperation("公会成员列表")
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ServiceResponse<PageBean<UserInfoResponse>> guildMembers(GuildRequest request) {
        ServiceResponse<PageBean<UserInfoResponse>> response = openGuildService.queryGuildMember(request);
        return response;
    }

    @ApiOperation("上传公会头像")
    @RequestMapping(value = "/uploadGuildPhoto", method = RequestMethod.POST)
    public ServiceResponse<String> uploadPhoto(GuildRequest request, @RequestParam("file") MultipartFile file) {
        ServiceResponse<String> response = new ServiceResponse<String>();
        try {
            String path = ImgUploadUtil.uploadImg(file, IMAGE_UPLOAD_URL);
            if(StringUtil.isEmpty(path)) {
                request.setPhotoPath(path);
                response = openGuildService.uploadGuildPhoto(request);
            } else {
                return new ServiceResponse<String>(BaseResponseCode.FAILURE);
            }
        } catch (Exception e) {
            return new ServiceResponse<String>(BaseResponseCode.FAILURE);
        }
        return response;
    }
}
