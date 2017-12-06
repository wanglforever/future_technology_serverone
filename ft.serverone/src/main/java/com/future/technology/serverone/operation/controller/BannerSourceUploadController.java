package com.future.technology.serverone.operation.controller;

import com.future.technology.serverone.operation.domain.BSouceBean;
import com.future.technology.serverone.operation.service.IBannerUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by three on 2017/12/5.
 */
@RestController
public class BannerSourceUploadController {
    @Autowired
    private IBannerUploadService bannerUploadService;

    @PostMapping("/banner/upload" )
    public BSouceBean imgUpload(@RequestParam(value = "file") MultipartFile[] file) {
        return bannerUploadService.imgUpload(file);
    }
}
