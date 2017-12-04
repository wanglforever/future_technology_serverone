package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.EssayStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.essay.domain.PictureBean;
import com.future.technology.serverone.utils.GetDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by three on 2017/12/4.
 */
@Service
@Slf4j
public class PictureService implements IPictureService {
    @Value("${essay.pictureLocation}")
    private String pictureLocation;
    @Override
    public Response<PictureBean> imgUpload(MultipartFile file) {
        PictureBean pictureBean = new PictureBean();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 命名格式20171204152038_img.ong
        fileName = GetDateUtil.suffixDateFormat()+ "_" + suffixName;
        File dest = new File(pictureLocation + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            pictureBean.getPicList().add(pictureLocation + fileName);
            return new Response<PictureBean>(ResponseStatus.SUCCESS, EssayStatus.PICTURECOD_500,EssayStatus.PICTUREMES_501, pictureBean);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        pictureBean.setErrno(1);
        return new Response<PictureBean>(ResponseStatus.FAIL,EssayStatus.PICTURECOD_500,EssayStatus.PICTUREMES_502, pictureBean);
    }
}
