package com.manba.simple.upload;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lijin on 2017/9/29.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
public class ManBaUploadApplicationLauncher {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ManBaUploadApplicationLauncher.class);

    public static void main(String args[]) {
        SpringApplication.run(ManBaUploadApplicationLauncher.class, args);
        LOGGER.info("图片存储服务启动成功！！！！！！！！！！！！！！！");
    }
}
