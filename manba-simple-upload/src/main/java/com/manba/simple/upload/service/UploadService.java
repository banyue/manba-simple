package com.manba.simple.upload.service;

import com.manba.simple.upload.domain.UploadRequest;

import java.io.InputStream;

/**
 * Created by lijin on 2017/9/29.
 */
public interface UploadService {

    String saveFile(UploadRequest request, InputStream stream, String rootPath);
}
