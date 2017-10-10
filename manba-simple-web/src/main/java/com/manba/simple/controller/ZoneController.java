package com.manba.simple.controller;

import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.PublishZoneRequest;
import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.CommentInfo;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.ui.Model;
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
    public ServiceResponse<Integer> publishZone(PublishZoneRequest request) {
        ServiceResponse<Integer> response = openZoneService.publishZone(request);
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
    public ServiceResponse<Boolean> follow(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Boolean> response = openZoneService.follow();
        return response;
    }

    @ApiOperation("关注列表")
    @RequestMapping(value = "/followList", method = RequestMethod.GET)
    public ServiceResponse<UserInfoResponse> followList(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<UserInfoResponse> response = openZoneService.followList();
        return response;
    }

    @ApiOperation("点赞某条动态")
    @RequestMapping(value = "/upvote", method = RequestMethod.GET)
    public ServiceResponse<Boolean> upvote(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Boolean> response = openZoneService.upvote();
        return response;
    }

    @ApiOperation("点赞列表")
    @RequestMapping(value = "/upvoteList", method = RequestMethod.GET)
    public ServiceResponse<UserInfoResponse> upvoteList(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<UserInfoResponse> response = openZoneService.upvoteList();
        return response;
    }

    @ApiOperation("评论动态")
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ServiceResponse<Long> comment(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Long> response = openZoneService.comment();
        return response;
    }

    @ApiOperation("回复评论")
    @RequestMapping(value = "/applyComment", method = RequestMethod.GET)
    public ServiceResponse<Long> applyComment(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Long> response = openZoneService.applyComment();
        return response;
    }

    @ApiOperation("查询评论列表")
    @RequestMapping(value = "/queryCommentList", method = RequestMethod.GET)
    public ServiceResponse<PageBean<CommentInfo>> queryCommentList(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<PageBean<CommentInfo>> response = openZoneService.queryCommentList();
        return response;
    }

    @ApiOperation("相册列表")
    @RequestMapping(value = "/photoList", method = RequestMethod.GET)
    public ServiceResponse<List<String>> photoList(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<List<String>> response = openZoneService.photoList();
        return response;
    }

    @ApiOperation("获取点赞数")
    @RequestMapping(value = "/getUpvoteNum", method = RequestMethod.GET)
    public ServiceResponse<Integer> getUpvoteNum(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Integer> response = openZoneService.getUpvoteNum();
        return response;
    }

    @ApiOperation("获取关注数")
    @RequestMapping(value = "/getFollowNum", method = RequestMethod.GET)
    public ServiceResponse<Integer> getFollowNum(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Integer> response = openZoneService.getFollowNum();
        return response;
    }
}
