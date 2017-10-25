package com.manba.simple.controller;

import com.manba.simple.api.OpenGuildService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.request.GuildUserRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 公会相关网关接口
 * Created by lijin on 2017/9/28.
 */
@RestController
@RequestMapping("/guild")
public class GuildController {

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
}
