package com.future.technology.serverone.essay.domain;

/**
 * Created by three on 2017/11/30.
 */
public class Essay {
    private Long    essay_id;
    private String  essay_title;
    private Integer catogory_id;
    private Integer status_id;
    private String  essay_mktime;
    private String  essay_modtime;
    private String  essay_content;

    public Long getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(Long essay_id) {
        this.essay_id = essay_id;
    }

    public String getEssay_title() {
        return essay_title;
    }

    public void setEssay_title(String essay_title) {
        this.essay_title = essay_title;
    }

    public Integer getCatogory_id() {
        return catogory_id;
    }

    public void setCatogory_id(Integer catogory_id) {
        this.catogory_id = catogory_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getEssay_mktime() {
        return essay_mktime;
    }

    public void setEssay_mktime(String essay_mktime) {
        this.essay_mktime = essay_mktime;
    }

    public String getEssay_modtime() {
        return essay_modtime;
    }

    public void setEssay_modtime(String essay_modtime) {
        this.essay_modtime = essay_modtime;
    }

    public String getEssay_content() {
        return essay_content;
    }

    public void setEssay_content(String essay_content) {
        this.essay_content = essay_content;
    }
}
