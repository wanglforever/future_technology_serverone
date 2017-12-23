package com.future.technology.serverone.essay.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by three on 2017/11/30.
 */
@Getter
@Setter
public class Essay {
    private Long    essay_id;
    /**
     * 内容标题
     */
    private String  essay_title;
    /**
     * 类别，1是咨询动态 2是公告信息
     */
    private Integer catogory_id;
    /**
     * 状态 0是上线 1是下线
     */
    private Integer status_id;
    private String  essay_mktime;
    private String  essay_modtime;
    private String  essay_content;
    /**
     * 预览图
     */
    private String  essay_preview;
}
