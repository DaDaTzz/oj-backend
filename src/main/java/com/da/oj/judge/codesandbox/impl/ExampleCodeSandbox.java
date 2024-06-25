package com.da.oj.judge.codesandbox.impl;

import com.da.oj.judge.codesandbox.CodeSandbox;
import com.da.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.da.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.da.oj.model.dto.questionSubmit.JudgeInfo;
import com.da.oj.model.enums.JudgeInfoMessageEnum;
import com.da.oj.model.enums.QuestionSubmitStatesEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatesEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.Accepted.getText());
        judgeInfo.setMemory(200L);
        judgeInfo.setTime(200L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
