package com.future.technology.serverone.operation.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by three on 2017/12/5.
 */
public class BSouceBean{
    private Integer errno = new Integer(0);
    private List<String> data = new ArrayList<>();

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

    public BSouceBean(){}
    public BSouceBean(Integer errno) {
        this.errno = errno;
    }
}
