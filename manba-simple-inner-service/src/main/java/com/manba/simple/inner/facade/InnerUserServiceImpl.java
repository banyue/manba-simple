package com.manba.simple.inner.facade;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.common.exception.BaseMsgException;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.entity.ManSimpleGuildEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.GuildEntityRequest;
import com.manba.simple.domain.inside.UserEntityRequest;
import com.manba.simple.inner.api.InnerUserService;
import com.manba.simple.inner.domain.request.UserInnerRequest;
import com.manba.simple.inner.domain.response.UserInnerRespone;
import com.manba.simple.service.inner.UserInnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijin on 2017/10/28.
 */
@Service
public class InnerUserServiceImpl implements InnerUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InnerUserServiceImpl.class);

    @Resource
    UserInnerService userInnerService;

    @Override
    public ServiceResponse<PageBean<UserInnerRespone>> queryUserList(UserInnerRequest request) {
        LOGGER.info("Inner查询用户入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<UserInnerRespone>> response = new ServiceResponse<PageBean<UserInnerRespone>>();
        UserEntityRequest userEntityRequest = new UserEntityRequest();
        userEntityRequest.setUserId(request.getUserId());
        userEntityRequest.setInteresting(request.getInteresting());
        userEntityRequest.setNickName(request.getNickName());
        userEntityRequest.setPhone(request.getPhone());
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleUserEntity> entities = userInnerService.queryUserListPage(userEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("Inner查询用户业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<UserInnerRespone>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("Inner查询用户异常！{}", e);
            return new ServiceResponse<PageBean<UserInnerRespone>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("Inner查询用户出参：{}", JSON.toJSONString(response));
        return response;
    }
}
