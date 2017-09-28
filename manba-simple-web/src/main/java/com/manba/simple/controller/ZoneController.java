package com.manba.simple.controller;

import com.manba.simple.api.OpenZoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 动态相关网关接口
 * Created by lijin on 2017/9/28.
 */
@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Resource
    OpenZoneService openZoneService;


}
