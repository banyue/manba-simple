package com.manba.simple;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 漫吧对外网关启动服务器
 * Created by lijin on 2017/9/27.
 */
@SpringBootApplication
@EnableSwagger2
public class ManBaApplicationLauncher {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ManBaApplicationLauncher.class);

    public static void main(String args[]) {
        SpringApplication.run(ManBaApplicationLauncher.class, args);
        LOGGER.info("服务启动成功！！！！！！！！！！！！！！！");
    }
}
