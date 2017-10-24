package com.manba.simple.controller;

import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.*;
import com.manba.simple.domain.response.CommentInfoResponse;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动态相关网关接口
 * Created by lijin on 2017/9/28.
 */
@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Resource
    OpenZoneService openZoneService;

    @ApiOperation("获取动态列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<PageBean<ZoneResponse>> zoneList(ZoneRequest request) {
        ServiceResponse<PageBean<ZoneResponse>> response = openZoneService.queryZoneList(request);
        return response;
    }

    @ApiOperation("获取动态详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ServiceResponse<ZoneResponse> zoneDetail(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<ZoneResponse> response = openZoneService.queryZoneDetail(request);
        return response;
    }

    @ApiOperation("发布动态")
    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public ServiceResponse<Long> publishZone(PublishZoneRequest request) {
        ServiceResponse<Long> response = openZoneService.publishZone(request);
        return response;
    }

    @ApiOperation("删除动态")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ServiceResponse<Integer> deleteZone(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Integer> response = openZoneService.deleteZone(request);
        return response;
    }

    @ApiOperation("关注某人")
    @RequestMapping(value = "/follow", method = RequestMethod.GET)
    public ServiceResponse<Long> follow(String userId, String followId) {
        FollowRequest request = new FollowRequest();
        request.setFollowId(Long.valueOf(followId));
        request.setUserId(Long.valueOf(userId));
        ServiceResponse<Long> response = openZoneService.follow(request);
        return response;
    }

    @ApiOperation("关注列表")
    @RequestMapping(value = "/followList", method = RequestMethod.GET)
    public ServiceResponse<List<UserInfoResponse>> followList(@PathVariable String userId) {
        ServiceResponse<List<UserInfoResponse>> response = openZoneService.followList(Long.valueOf(userId));
        return response;
    }

    @ApiOperation("点赞某条动态")
    @RequestMapping(value = "/upvote", method = RequestMethod.GET)
    public ServiceResponse<Long> upvote(String userId, String zoneId) {
        UpvoteRequest request = new UpvoteRequest();
        request.setUserId(Long.valueOf(userId));
        request.setZoneId(Long.valueOf(zoneId));
        ServiceResponse<Long> response = openZoneService.upvote(request);
        return response;
    }

    @ApiOperation("点赞列表")
    @RequestMapping(value = "/upvoteList", method = RequestMethod.GET)
    public ServiceResponse<List<UserInfoResponse>> upvoteList(@PathVariable String zoneId) {
        ServiceResponse<List<UserInfoResponse>> response = openZoneService.upvoteList(Long.valueOf(zoneId));
        return response;
    }

    @ApiOperation("评论动态")
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ServiceResponse<Long> comment(CommentRequest request) {
        ServiceResponse<Long> response = openZoneService.comment(request);
        return response;
    }

    @ApiOperation("查询评论列表")
    @RequestMapping(value = "/queryCommentList", method = RequestMethod.GET)
    public ServiceResponse<PageBean<CommentInfoResponse>> queryCommentList(@PathVariable String id) {
        CommentListRequest request = new CommentListRequest();
        ServiceResponse<PageBean<CommentInfoResponse>> response = openZoneService.queryCommentList(request);
        return response;
    }

    @ApiOperation("相册列表")
    @RequestMapping(value = "/photoList", method = RequestMethod.GET)
    public ServiceResponse<List<String>> photoList(@PathVariable String userId) {
        ServiceResponse<List<String>> response = openZoneService.photoList(Long.valueOf(userId));
        return response;
    }

    @ApiOperation("获取点赞数")
    @RequestMapping(value = "/getUpvoteNum", method = RequestMethod.GET)
    public ServiceResponse<Integer> getUpvoteNum(@PathVariable String zoneId) {
        ServiceResponse<Integer> response = openZoneService.getUpvoteNum(Long.valueOf(zoneId));
        return response;
    }

    @ApiOperation("获取关注数")
    @RequestMapping(value = "/getFollowNum", method = RequestMethod.GET)
    public ServiceResponse<Integer> getFollowNum(@PathVariable String userId) {
        ServiceResponse<Integer> response = openZoneService.getFollowNum(Long.valueOf(userId));
        return response;
    }
}
