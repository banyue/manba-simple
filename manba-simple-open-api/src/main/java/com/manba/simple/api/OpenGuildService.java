package com.manba.simple.api;

import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.request.GuildUserRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.UserInfoResponse;

/**
 * 公会对外服务接口
 * Created by lijin on 2017/9/26.
 */
public interface OpenGuildService {

    /**
     * 查询公会列表
     * @param request
     * @return
     */
    ServiceResponse<PageBean<GuildResponse>> queryGuildList(GuildRequest request);

    /**
     * 创建公会
     * @param request
     * @return
     */
    ServiceResponse<Long> createGuild(CreateGuildRequest request);

    /**
     * 查询公会详情
     * @param request
     * @return
     */
    ServiceResponse<GuildResponse> getGuildInfo(GuildRequest request);

    /**
     * 查询公会成员
     * @param request
     * @return
     */
    ServiceResponse<PageBean<UserInfoResponse>> queryGuildMember(GuildRequest request);

    /**
     * 加入公会
     * @param request
     * @return
     */
    ServiceResponse<Long> addGuild(GuildUserRequest request);

    /**
     * 退出公会
     * @param request
     * @return
     */
    ServiceResponse<Integer> quitGuild(GuildUserRequest request);

    /**
     * 上传头像
     * @param request
     * @return
     */
    ServiceResponse<String> uploadGuildPhoto(GuildRequest request);
}
