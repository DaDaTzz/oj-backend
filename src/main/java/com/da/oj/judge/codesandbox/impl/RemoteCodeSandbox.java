package com.da.oj.judge.codesandbox.impl;

import com.da.oj.judge.codesandbox.CodeSandbox;
import com.da.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.da.oj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
