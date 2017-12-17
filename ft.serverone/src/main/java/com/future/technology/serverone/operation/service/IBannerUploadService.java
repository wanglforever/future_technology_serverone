package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.operation.domain.BSouceBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by three on 2017/12/5.
 */
public interface IBannerUploadService {
    BSouceBean imgUpload(MultipartFile[] file);
}
