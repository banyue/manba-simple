package com.manba.simple.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 漫吧对外网关启动服务器
 * Created by lijin on 2017/9/27.
 */
@SpringBootApplication
public class ManBaApplicationLauncher {

    public static void main(String args[]) {
        SpringApplication.run(ManBaApplicationLauncher.class, args);
    }
}
