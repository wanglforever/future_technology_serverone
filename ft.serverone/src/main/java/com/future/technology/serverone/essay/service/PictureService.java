package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.essay.domain.PictureBean;
import com.future.technology.serverone.utils.GetDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by three on 2017/12/4.
 */
@Service
@Slf4j
@Transactional
public class PictureService implements IPictureService {

    @Value("${essay.pictureLocation}")
    private String pictureLocation;
    @Override
    public PictureBean imgUpload(MultipartFile[] fileArray) {
        if (fileArray == null )
            return new PictureBean(1);
        if(fileArray.length == 0)
            return new PictureBean(1);

        PictureBean pictureBean = new PictureBean();
        for (int i = 0; i < fileArray.length; i++) {
            MultipartFile file =  fileArray[i];
            String fileName = file.getOriginalFilename();
            // 命名格式20171204152038_img.png
            fileName = GetDateUtil.suffixDateFormat()+ "_" + fileName;
            File dest = new File(pictureLocation + fileName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                pictureBean.getData().add(pictureLocation + fileName);
            } catch (IllegalStateException e) {
                log.error("erro,{}",e);
                pictureBean.setErrno(1);
            }  catch (IOException e) {
                pictureBean.setErrno(1);
                log.error("erro,{}",e);
            }
        }
        return pictureBean;
    }
}
