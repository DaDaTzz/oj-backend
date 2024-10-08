package com.da.oj.model.dto.questionSubmit;

import lombok.Data;

/**
 *  判题信息
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存 kb
     */
    private Long memory;

    /**
     * 消耗时间
     */
    private Long time;
}
