package com.manba.simple.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lijin on 2017/10/10.
 * 加载图片等公共对外接口
 */
@RestController
@RequestMapping("/comm")
public class CommonController {

    @ApiOperation("加载图片")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, String path) {
        String paths[] = path.split("\\\\");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + paths[paths.length - 1] + "\"");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(path));
            bos = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[2048];
            int bytesRead;

            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bos.flush();
        } catch (final IOException e) {
            System.out.println("IOException." + e);
        } finally {
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    System.out.println("IOException." + e);
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    System.out.println("IOException." + e);
                }
        }
    }
}
