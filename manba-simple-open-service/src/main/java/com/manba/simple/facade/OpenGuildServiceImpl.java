package com.manba.simple.facade;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manba.simple.api.OpenGuildService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.exception.BaseMsgException;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimpleGuildEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.GuildEntityRequest;
import com.manba.simple.domain.inside.GuildUserEntityRequest;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.CreateGuildRequest;
import com.manba.simple.domain.request.GuildRequest;
import com.manba.simple.domain.request.GuildUserRequest;
import com.manba.simple.domain.response.GuildResponse;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import com.manba.simple.service.GuildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class OpenGuildServiceImpl implements OpenGuildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenGuildServiceImpl.class);

    @Resource
    GuildService guildService;

    @Override
    public ServiceResponse<PageBean<GuildResponse>> queryGuildList(GuildRequest request) {
        LOGGER.info("公会列表入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<GuildResponse>> response = new ServiceResponse<PageBean<GuildResponse>>();
        GuildEntityRequest guildEntityRequest = new GuildEntityRequest();
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleGuildEntity> entities = guildService.selectGuildList(guildEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("公会列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<GuildResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("公会列表异常！{}", e);
            return new ServiceResponse<PageBean<GuildResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("公会列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> createGuild(CreateGuildRequest request) {
        LOGGER.info("创建公会入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        ManSimpleGuildEntity entity = new ManSimpleGuildEntity();
        try {
            //参数校验
            Map<String, Object> param = createGuildParamMap(request);
            String checkInfo = StringUtil.checkEmpty(param);
            if (!StringUtil.isEmpty(checkInfo)) {
                BaseResponseCode.PARAM_ERROR.setMsg(checkInfo);
                return new ServiceResponse<Long>(BaseResponseCode.PARAM_ERROR);
            }
            entity.setCreateUser(Long.valueOf(request.getUserId()));
            entity.setGuildName(request.getGuildName());
            entity.setYn(YnEnum.YES.getCode());
            // TODO: 其他数据
            Long id = guildService.createGuild(entity);
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("创建公会业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("创建公会异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("创建公会出参：{}", JSON.toJSONString(response));
        return response;
    }

    private Map<String, Object> createGuildParamMap(CreateGuildRequest request) {
        if(null == request) {
            return null;
        }
        Map<String, Object> param = new HashMap<>(3);
        param.put("userId", request.getUserId());
        param.put("guildName", request.getGuildName());
        param.put("memeberNum", request.getMemberNum());
        return param;
    }

    @Override
    public ServiceResponse<GuildResponse> getGuildInfo(GuildRequest request) {
        LOGGER.info("公会详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<GuildResponse> response = new ServiceResponse<GuildResponse>();
        try {
            if(StringUtil.isEmpty(request.getGuildId())) {
                return new ServiceResponse<GuildResponse>(BaseResponseCode.PARAM_ERROR);
            }
            ManSimpleGuildEntity entity = guildService.selectOneGuild(Long.valueOf(request.getGuildId()));
            GuildResponse guild = new GuildResponse();
            // TODO: 2017/10/24
            response.setResult(guild);
        } catch (BaseMsgException msg) {
            LOGGER.error("公会详情业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<GuildResponse>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("公会详情异常！{}", e);
            return new ServiceResponse<GuildResponse>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("公会详情出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<PageBean<UserInfoResponse>> queryGuildMember(GuildRequest request) {
        LOGGER.info("查询公会会员入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<UserInfoResponse>> response = new ServiceResponse<PageBean<UserInfoResponse>>();
        GuildUserEntityRequest userEntityRequest = new GuildUserEntityRequest();
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleUserEntity> entities = guildService.queryGuildMember(userEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("查询公会会员业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<UserInfoResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("查询公会会员异常！{}", e);
            return new ServiceResponse<PageBean<UserInfoResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("查询公会会员出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> addGuild(GuildUserRequest request) {
        LOGGER.info("加入公会入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        try {
            Long id = guildService.addGuild(Long.valueOf(request.getUserId()), Long.valueOf(request.getGuildId()));
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("加入公会业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("加入公会异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("加入公会出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Integer> quitGuild(GuildUserRequest request) {
        LOGGER.info("退出公会入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer id = guildService.quitGuild(Long.valueOf(request.getUserId()), Long.valueOf(request.getGuildId()));
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("退出公会业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("退出公会异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("退出公会出参：{}", JSON.toJSONString(response));
        return response;
    }
}
