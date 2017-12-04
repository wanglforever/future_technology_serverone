package com.future.technology.serverone.essay.domain;

/**
 * Created by three on 2017/12/3.
 */
public class QueryInfo  {
    private String start_time;
    private String end_time;
    private String catogory_id;
    private String status_id;
    private String essay_title;

    private Integer currentPage = 1;
    private Long startRecord;
    private Long endRecord;

    public Long getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Long startRecord) {
        this.startRecord = startRecord;
    }

    public Long getEndRecord() {
        return endRecord;
    }

    public void setEndRecord(Long endRecord) {
        this.endRecord = endRecord;
    }


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCatogory_id() {
        return catogory_id;
    }

    public void setCatogory_id(String catogory_id) {
        this.catogory_id = catogory_id;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getEssay_title() {
        return essay_title;
    }

    public void setEssay_title(String essay_title) {
        this.essay_title = essay_title;
    }
}
