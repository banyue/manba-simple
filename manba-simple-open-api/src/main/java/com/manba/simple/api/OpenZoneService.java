package com.manba.simple.api;

import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.*;
import com.manba.simple.domain.response.*;

import java.util.List;

/**
 * 动态对外服务接口
 * Created by lijin on 2017/9/26.
 */
public interface OpenZoneService {

    /**
     * 分页查询动态列表
     * @param request
     * @return
     */
    ServiceResponse<PageBean<ZoneResponse>> queryZoneList(ZoneRequest request);

    /**
     * 发布动态
     * @param request
     * @return
     */
    ServiceResponse<Long> publishZone(PublishZoneRequest request);

    /**
     * 查询动态详情
     * @param request
     * @return
     */
    ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request);

    /**
     * 删除动态
     * @param request
     * @return
     */
    ServiceResponse<Integer> deleteZone(ZoneRequest request);

    /**
     * 关注某
     * @param request
     * @return
     */
    ServiceResponse<Long> follow(FollowRequest request);

    /**
     * 关注列表
     * @param userId
     * @return
     */
    ServiceResponse<List<UserInfoResponse>> followList(Long userId);

    /**
     * 点赞某条动态
     * @param request
     * @return
     */
    ServiceResponse<Long> upvote(UpvoteRequest request);

    /**
     * 点赞列表
     * @param zoneId
     * @return
     */
    ServiceResponse<List<UserInfoResponse>> upvoteList(Long zoneId);

    /**
     * 评论动态
     * @param request
     * @return
     */
    ServiceResponse<Long> comment(CommentRequest request);

    /**
     * 查询评论列表
     * @return
     */
    ServiceResponse<PageBean<CommentInfoResponse>> queryCommentList(CommentListRequest request);

    /**
     * 相册列表
     * @param userId
     * @return
     */
    ServiceResponse<List<String>> photoList(Long userId);

    /**
     * 获取点赞数
     * @param zoneId
     * @return
     */
    ServiceResponse<Integer> getUpvoteNum(Long zoneId);

    /**
     * 获取关注数
     * @param userId
     * @return
     */
    ServiceResponse<Integer> getFollowNum(Long userId);

    /**
     * 收藏
     * @param request
     * @return
     */
    ServiceResponse<Long> favorite(UpvoteRequest request);

    /**
     * 取消收藏
     * @param request
     * @return
     */
    ServiceResponse<Integer> cancelFavorite(UpvoteRequest request);

    /**
     * 收藏列表
     * @param request
     * @return
     */
    ServiceResponse<PageBean<ZoneResponse>> favoriteList(ZoneRequest request);
}
