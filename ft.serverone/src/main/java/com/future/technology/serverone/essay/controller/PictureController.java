package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.essay.domain.PictureBean;
import com.future.technology.serverone.essay.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by three on 2017/12/4.
 */
@RestController
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @PostMapping("/essay/upload" )
    public PictureBean imgUpload(@RequestParam(value = "file") MultipartFile[] file) {
        return pictureService.imgUpload(file);
    }
}
