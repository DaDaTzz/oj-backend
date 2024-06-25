package com.da.oj.judge.codesandbox;

import com.da.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.da.oj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
