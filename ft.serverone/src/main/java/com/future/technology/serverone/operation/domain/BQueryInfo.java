package com.future.technology.serverone.operation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by three on 2017/12/5.
 */
@NoArgsConstructor
@Data
public class BQueryInfo {
    private String bStartTime;
    private String bEndTime;
    private String bTitle;
    private String bStatus;


    private Integer currentPage = 1;
    private Long offset;
    private Long offcount;
}
