package com.manba.simple.open.facade;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manba.simple.api.OpenZoneService;
import com.manba.simple.common.domain.BaseResponseCode;
import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.common.exception.BaseMsgException;
import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimpleCommentEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.CommentEntityRequest;
import com.manba.simple.domain.inside.FavoriteEntityRequest;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.domain.request.*;
import com.manba.simple.domain.response.CommentInfoResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import com.manba.simple.service.open.UserService;
import com.manba.simple.service.open.ZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class OpenZoneServiceImpl implements OpenZoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenZoneServiceImpl.class);

    @Resource
    ZoneService zoneService;
    @Resource
    UserService userService;

    @Override
    public ServiceResponse<PageBean<ZoneResponse>> queryZoneList(ZoneRequest request) {
        LOGGER.info("查询动态列表入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<ZoneResponse>> response = new ServiceResponse<PageBean<ZoneResponse>>();
        ZoneEntityRequest zoneEntityRequest = new ZoneEntityRequest();
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
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

    @Override
    public ServiceResponse<Long> publishZone(PublishZoneRequest request) {
        LOGGER.info("发布动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        ManSimpleZoneEntity entity = new ManSimpleZoneEntity();
        try {
            //参数校验
            Map<String, Object> param = publishZoneParamMap(request);
            String checkInfo = StringUtil.checkEmpty(param);
            if (!StringUtil.isEmpty(checkInfo)) {
                BaseResponseCode.PARAM_ERROR.setMsg(checkInfo);
                return new ServiceResponse<Long>(BaseResponseCode.PARAM_ERROR);
            }
            entity.setZoneContent(request.getZoneContent());
            entity.setZoneTitle(request.getZoneTitle());
            entity.setZoneImage(request.getZoneImage());
            entity.setUserId(request.getUserId());
            entity.setPublishTime(new Date());
            entity.setYn(YnEnum.YES.getCode());
            Long id = zoneService.createZone(entity);
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("发布动态业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("发布动态异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("发布动态详情出参：{}", JSON.toJSONString(response));
        return response;
    }

    private Map<String, Object> publishZoneParamMap(PublishZoneRequest request) {
        if(null == request) {
            return null;
        }
        Map<String, Object> param = new HashMap<>(3);
        param.put("userId", request.getUserId());
        param.put("zoneTitle", request.getZoneTitle());
        param.put("zoneContent", request.getZoneContent());
        return param;
    }

    @Override
    public ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request) {
        LOGGER.info("查询动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<ZoneResponse> response = new ServiceResponse<ZoneResponse>();
        try {
            if(StringUtil.isEmpty(request.getZoneId())) {
                return new ServiceResponse<ZoneResponse>(BaseResponseCode.PARAM_ERROR);
            }
            ManSimpleZoneEntity entity = zoneService.selectOneZone(Long.valueOf(request.getZoneId()));
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

    @Override
    public ServiceResponse<Integer> deleteZone(ZoneRequest request) {
        LOGGER.info("删除动态详情入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer id = zoneService.deleteZone(Long.valueOf(request.getZoneId()));
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

    @Override
    public ServiceResponse<Long> follow(FollowRequest request) {
        LOGGER.info("关注某人入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        try {
            Long id = zoneService.follow(request.getUserId(), request.getFollowId());
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("关注某人业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("关注某人异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("关注某人出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<List<UserInfoResponse>> followList(Long userId) {
        LOGGER.info("关注列表入参：{}", userId);
        ServiceResponse<List<UserInfoResponse>> response = new ServiceResponse<List<UserInfoResponse>>();
        List<UserInfoResponse> result = new ArrayList<>();
        try {
            List<ManSimpleUserEntity> list = zoneService.followList(userId);
            //参数转换
            UserInfoResponse info;
            for(ManSimpleUserEntity entity : list) {
                info = new UserInfoResponse();
                info.setUserId(entity.getId());
                info.setPhotoUrl(entity.getPhotoUrl());
                result.add(info);
            }
            response.setResult(result);
        } catch (BaseMsgException msg) {
            LOGGER.error("关注列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<List<UserInfoResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("关注列表异常！{}", e);
            return new ServiceResponse<List<UserInfoResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("关注列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> upvote(UpvoteRequest request) {
        LOGGER.info("点赞入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        try {
            Long id = zoneService.upvote(request.getUserId(), request.getZoneId());
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("点赞业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("点赞异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("点赞出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<List<UserInfoResponse>> upvoteList(Long zoneId) {
        LOGGER.info("点赞列表入参：{}", zoneId);
        ServiceResponse<List<UserInfoResponse>> response = new ServiceResponse<List<UserInfoResponse>>();
        List<UserInfoResponse> result = new ArrayList<>();
        try {
            List<ManSimpleUserEntity> list = zoneService.upvoteList(zoneId);
            //参数转换
            UserInfoResponse info;
            for(ManSimpleUserEntity entity : list) {
                info = new UserInfoResponse();
                info.setUserId(entity.getId());
                info.setPhotoUrl(entity.getPhotoUrl());
                result.add(info);
            }
            response.setResult(result);
        } catch (BaseMsgException msg) {
            LOGGER.error("点赞列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<List<UserInfoResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("点赞列表异常！{}", e);
            return new ServiceResponse<List<UserInfoResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("点赞列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> comment(CommentRequest request) {
        LOGGER.info("评论入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        try {
            ManSimpleCommentEntity entity = new ManSimpleCommentEntity();
            entity.setZoneId(request.getZoneId());
            entity.setUserId(request.getUserId());
            entity.setContent(request.getContent());
            entity.setParentId(null == request.getCommentParentId() ? 0L : request.getCommentParentId());
            Long id = zoneService.comment(entity);
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("评论业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("评论异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("评论出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<PageBean<CommentInfoResponse>> queryCommentList(CommentListRequest request) {
        LOGGER.info("查询评论列表入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<CommentInfoResponse>> response = new ServiceResponse<PageBean<CommentInfoResponse>>();
        CommentEntityRequest commentEntityRequest = new CommentEntityRequest();
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleCommentEntity> entities = zoneService.selectCommentList(commentEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("查询评论列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<CommentInfoResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("查询评论列表异常！{}", e);
            return new ServiceResponse<PageBean<CommentInfoResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("查询评论列表出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<List<String>> photoList(Long userId) {
        LOGGER.info("相册入参：{}", userId);
        ServiceResponse<List<String>> response = new ServiceResponse<List<String>>();
        try {
            List<String> list = userService.photoList(userId);
            response.setResult(list);
        } catch (BaseMsgException msg) {
            LOGGER.error("相册业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<List<String>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("相册异常！{}", e);
            return new ServiceResponse<List<String>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("相册出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Integer> getUpvoteNum(Long zoneId) {
        LOGGER.info("获取点赞数入参：{}", zoneId);
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer num = zoneService.getUpvoteNum(zoneId);
            response.setResult(num);
        } catch (BaseMsgException msg) {
            LOGGER.error("获取点赞数业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("获取点赞数异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("获取点赞数出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Integer> getFollowNum(Long userId) {
        LOGGER.info("获取关注数入参：{}", userId);
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer num = userService.getFollowNum(userId);
            response.setResult(num);
        } catch (BaseMsgException msg) {
            LOGGER.error("获取关注数业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("获取关注数异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("获取关注数出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Long> favorite(UpvoteRequest request) {
        LOGGER.info("收藏动态入参：{}", JSON.toJSONString(request));
        ServiceResponse<Long> response = new ServiceResponse<Long>();
        try {
            Long id = zoneService.follow(request.getUserId(), request.getZoneId());
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("收藏动态业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Long>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("收藏动态异常！{}", e);
            return new ServiceResponse<Long>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("收藏动态出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<Integer> cancelFavorite(UpvoteRequest request) {
        LOGGER.info("取消收藏入参：{}", JSON.toJSONString(request));
        ServiceResponse<Integer> response = new ServiceResponse<Integer>();
        try {
            Integer id = zoneService.cancelFavorite(request.getUserId(), request.getZoneId());
            response.setResult(id);
        } catch (BaseMsgException msg) {
            LOGGER.error("取消收藏业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<Integer>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("取消收藏异常！{}", e);
            return new ServiceResponse<Integer>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("取消收藏出参：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public ServiceResponse<PageBean<ZoneResponse>> favoriteList(ZoneRequest request) {
        LOGGER.info("收藏列表入参：{}", JSON.toJSONString(request));
        PageBean pageBean = new PageBean();
        ServiceResponse<PageBean<ZoneResponse>> response = new ServiceResponse<PageBean<ZoneResponse>>();
        FavoriteEntityRequest favoriteEntityRequest = new FavoriteEntityRequest();
        try {
            //分页查询
            if(StringUtil.isEmpty(request.getPageNo()) || StringUtil.isEmpty(request.getPageSize())) {
                request.setPageNo(1);
                request.setPageSize(10);
            }
            PageHelper.startPage(request.getPageNo(), request.getPageSize());
            List<ManSimpleZoneEntity> entities = zoneService.queryFavoriteList(favoriteEntityRequest);
            if (null != entities) {
                Page page = (Page) entities;
                pageBean.setPageNo(request.getPageNo());
                pageBean.setPageSize(request.getPageSize());
                pageBean.setTotalCount(page.getTotal());
                pageBean.setResultList(entities);
            }
            response.setResult(pageBean);
        } catch (BaseMsgException msg) {
            LOGGER.error("收藏列表业务异常！{}", JSON.toJSONString(msg));
            return new ServiceResponse<PageBean<ZoneResponse>>(msg.getCode(), msg.getMessage());
        } catch (Exception e) {
            LOGGER.error("收藏列表异常！{}", e);
            return new ServiceResponse<PageBean<ZoneResponse>>(BaseResponseCode.SYSTEM_ERROR);
        }
        LOGGER.info("收藏列表出参：{}", JSON.toJSONString(response));
        return response;
    }
}
