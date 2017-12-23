package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.operation.domain.BSouceBean;
import com.future.technology.serverone.utils.GetDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by three on 2017/12/5.
 */
@Service
@Slf4j
public class BannerUploadService implements IBannerUploadService {
    @Value("${operation.sourceLocation}")
    private String sourceLocation;
    @Value("${operation.requestUrl:'http://localhost:8880/sources/'}")
    private String rootURL;

    @Override
    public BSouceBean imgUpload(MultipartFile[] fileArray) {
        if (fileArray == null )
            return new BSouceBean(1);
        if(fileArray.length == 0)
            return new BSouceBean(1);
        BSouceBean bSouceBean = new BSouceBean();
        for (int i = 0; i < fileArray.length; i++) {
            MultipartFile file =  fileArray[i];
            String fileName = file.getOriginalFilename();
            String path = sourceLocation + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                bSouceBean.getData().add(rootURL+fileName);
            } catch (IllegalStateException e) {
                log.error("erro,{}",e);
                bSouceBean.setErrno(1);
            }  catch (IOException e) {
                bSouceBean.setErrno(1);
                log.error("erro,{}",e);
            }
        }
        return bSouceBean;
    }
}
