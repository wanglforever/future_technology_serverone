package com.future.technology.serverone.essay.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by three on 2017/12/4.
 */
public class PictureBean {
    // 默认是0，上传成功
    private Integer errno = new Integer(0);
    // 存放图片地址的容器
    private List<String> data = new ArrayList();
    public PictureBean(){}
    public PictureBean(Integer errno) {
        this.errno = errno;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
