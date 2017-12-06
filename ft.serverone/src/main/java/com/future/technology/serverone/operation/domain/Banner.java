package com.future.technology.serverone.operation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by three on 2017/12/5.
 */
@NoArgsConstructor
@Data
public class Banner {
    private Long banner_id;
    private String banner_name;
    private String banner_description;
    private String banner_source;
    private String ref_address;
    private Integer bposition_id = 0;
    private Integer bstatus_id = 0;
    private String banner_mktime;
    private String banner_modtime;
}
