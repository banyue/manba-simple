package com.manba.simple.facade;

import com.manba.simple.api.OpenGuildService;
import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class OpenGuildServiceImpl implements OpenGuildService {

    public ServiceResponse<List<GuildResponse>> queryGuildList(GuildRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> createGuild(CreateGuildRequest request) {
        return null;
    }

    public ServiceResponse<GuildResponse> getGuildInfo(GuildRequest request) {
        return null;
    }

    public ServiceResponse<List<GuildResponse>> queryGuildMember(GuildRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> addGuild() {
        return null;
    }
}
