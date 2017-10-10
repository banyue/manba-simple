package com.manba.simple.facade;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manba.simple.api.OpenZoneService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.exception.BaseMsgException;
import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.PublishZoneRequest;
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
import java.util.Date;
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
        try {
            //分页查询
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleZoneEntity> entities = zoneService.selectZoneList(zoneEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("查询动态列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<ZoneResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("查询动态列表异常！{}", e);
            return new ServiceResponse<PageBean<ZoneResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("查询动态列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    public ServiceResponse<Integer> publishZone(PublishZoneRequest request) {
        LOGGER.info("发布动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        ManSimpleZoneEntity entity = new ManSimpleZoneEntity();
        try {
            entity.setZoneContent(request.getZoneContent());
            entity.setZoneTitle(request.getZoneTitle());
            entity.setZoneImage(request.getZoneImage());
            entity.setUserId(request.getUserId());
            entity.setPublishTime(new Date());
            entity.setYn(YnEnum.YES.getCode());
            Long id = zoneService.createZone(entity);
            response.setResult(id.intValue());
        } catch (BaseMsgException msg) {
            LOGGER.error("发布动态业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("发布动态异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("发布动态详情出参：{}", JSON.toJSONString(response));
        return response;
    }

    public ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request) {
        LOGGER.info("查询动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<ZoneResponse> response = new ServiceResponse<ZoneResponse>();
        try {
            ManSimpleZoneEntity entity = zoneService.selectOneZone(Long.valueOf(request.getId()));
            ZoneResponse zone = new ZoneResponse();
            zone.setId(entity.getId());
            zone.setPublishTime(entity.getPublishTime());
            zone.setUserId(entity.getUserId());
            zone.setZoneContent(entity.getZoneContent());
            zone.setZoneImage(entity.getZoneImage());
            zone.setZoneTitle(entity.getZoneTitle());
            response.setResult(zone);
        } catch (BaseMsgException msg) {
            LOGGER.error("查询动态详情业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<ZoneResponse>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("查询动态详情异常！{}", e);
            return new ServiceResponse<ZoneResponse>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("查询动态详情出参：{}", JSON.toJSONString(response));
        return response;
    }

    public ServiceResponse<Integer> deleteZone(ZoneRequest request) {
        LOGGER.info("删除动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer id = zoneService.deleteZone(Long.valueOf(request.getId()));
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("删除动态业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("删除动态异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("删除动态详情出参：{}", JSON.toJSONString(response));
        return response;
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
