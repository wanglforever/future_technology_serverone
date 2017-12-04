package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.common.EssayStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
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

    @PostMapping("/upload" )
    public Response<PictureBean> imgUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return new Response(ResponseStatus.FAIL,EssayStatus.PICTURECOD_500,EssayStatus.PICTUREMES_505);
        }
        return pictureService.imgUpload(file);

    }
}
