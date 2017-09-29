package com.manba.simple.inner.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 漫吧后台web启动服务器
 * Created by lijin on 2017/9/27.
 */
@SpringBootApplication
public class ManBaInnerApplicationLauncher {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ManBaInnerApplicationLauncher.class);

    public static void main(String args[]) {
        SpringApplication.run(ManBaInnerApplicationLauncher.class, args);
        LOGGER.info("Inner服务启动成功！！！！！！！！！！！！！！！");
    }
}
