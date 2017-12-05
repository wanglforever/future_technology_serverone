package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.essay.domain.PictureBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by three on 2017/12/4.
 */
public interface IPictureService {
    PictureBean imgUpload(MultipartFile[] file);
}
