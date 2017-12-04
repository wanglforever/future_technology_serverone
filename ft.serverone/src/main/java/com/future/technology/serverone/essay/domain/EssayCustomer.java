package com.future.technology.serverone.essay.domain;

/**
 * Created by three on 2017/12/1.
 */
public class EssayCustomer extends Essay {
    private String catogory_name;
    private String status_name;

    public String getCatogory_name() {
        return catogory_name;
    }

    public void setCatogory_name(String catogory_name) {
        this.catogory_name = catogory_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
