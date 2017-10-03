package com.manba.simple.api;

import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.PublishZoneRequest;
import com.manba.simple.domain.request.ZoneRequest;
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
    ServiceResponse<Integer> publishZone(PublishZoneRequest request);

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
     * 关注某人
     * @return
     */
    ServiceResponse<Boolean> follow();

    /**
     * 关注列表
     * @return
     */
    ServiceResponse<UserInfoResponse> followList();

    /**
     * 点赞某条动态
     * @return
     */
    ServiceResponse<Boolean> upvote();

    /**
     * 点赞列表
     * @return
     */
    ServiceResponse<UserInfoResponse> upvoteList();

    /**
     * 评论动态
     * @return
     */
    ServiceResponse<Long> comment();

    /**
     * 回复评论
     * @return
     */
    ServiceResponse<Long> applyComment();

    /**
     * 查询评论列表
     * @return
     */
    ServiceResponse<PageBean<CommentInfo>> queryCommentList();

    /**
     * 相册列表
     * @return
     */
    ServiceResponse<List<String>> photoList();

    /**
     * 获取点赞数
     * @return
     */
    ServiceResponse<Integer> getUpvoteNum();

    /**
     * 获取关注数
     * @return
     */
    ServiceResponse<Integer> getFollowNum();
}
