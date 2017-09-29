package com.manba.simple.api;

import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.ServiceResponse;

import java.util.List;

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
    ServiceResponse<List<GuildResponse>> queryGuildList(GuildRequest request);

    /**
     * 创建公会
     * @param request
     * @return
     */
    ServiceResponse<Boolean> createGuild(CreateGuildRequest request);

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
    ServiceResponse<List<GuildResponse>> queryGuildMember(GuildRequest request);

    /**
     * 加入公会
     * @return
     */
    ServiceResponse<Boolean> addGuild();
}
