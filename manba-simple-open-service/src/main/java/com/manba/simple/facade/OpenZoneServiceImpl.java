package com.manba.simple.facade;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.CommentInfo;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import com.manba.simple.service.ZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class OpenZoneServiceImpl implements OpenZoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenZoneServiceImpl.class);

    @Resource
    ZoneService zoneService;

    public ServiceResponse<PageBean<ZoneResponse>> queryZoneList(ZoneRequest request) {
        LOGGER.info("查询动态列表入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<ZoneResponse>> response = new ServiceResponse<PageBean<ZoneResponse>>();
        ZoneEntityRequest zoneEntityRequest = new ZoneEntityRequest();
        //分页查询
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        List<ManSimpleZoneEntity> entities = zoneService.selectZoneList(zoneEntityRequest);
        if(null != entities) {
            Page page = (Page)entities;
            pageBean.setPageNo(request.getPageNo());
            pageBean.setPageSize(request.getPageSize());
            pageBean.setTotalCount(page.getTotal());
            pageBean.setResultList(entities);
        }
        response.setResult(pageBean);
        LOGGER.info("查询动态列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    public ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> follow() {
        return null;
    }

    public ServiceResponse<UserInfoResponse> followList() {
        return null;
    }

    public ServiceResponse<Boolean> upvote() {
        return null;
    }

    public ServiceResponse<UserInfoResponse> upvoteList() {
        return null;
    }

    public ServiceResponse<Long> comment() {
        return null;
    }

    public ServiceResponse<Long> applyComment() {
        return null;
    }

    public ServiceResponse<PageBean<CommentInfo>> queryCommentList() {
        return null;
    }

    public ServiceResponse<List<String>> photoList() {
        return null;
    }

    public ServiceResponse<Integer> getUpvoteNum() {
        return null;
    }

    public ServiceResponse<Integer> getFollowNum() {
        return null;
    }
}
