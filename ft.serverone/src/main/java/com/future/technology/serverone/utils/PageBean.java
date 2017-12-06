package com.future.technology.serverone.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by three on 2017/12/3.
 */
public class PageBean<T> {

    //当前页
    private Integer currentPage = 1;
    //当前页显示的条数
    private Integer currentCount = 10;
    //总条数
    private Integer totalCount;
    //总页数
    private Integer totalPage;
    //每页显示的数据
    private List<T> infoList = new ArrayList<T>();

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<T> infoList) {
        this.infoList = infoList;
    }
}
