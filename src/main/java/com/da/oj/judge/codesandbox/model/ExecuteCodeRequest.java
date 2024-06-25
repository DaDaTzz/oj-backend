package com.da.oj.judge.codesandbox.model;

import lombok.Data;

import java.util.List;

@Data
public class ExecuteCodeRequest {

    private List<String> inputList;

    /**
     * 代码
     */
    private String code;

    /**
     * 语言
     */
    private String language;



}
