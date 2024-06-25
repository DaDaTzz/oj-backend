package com.da.oj.judge.strategy;

import com.da.oj.model.dto.question.JudgeCase;
import com.da.oj.model.dto.questionSubmit.JudgeInfo;
import com.da.oj.model.entity.Question;
import com.da.oj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;
    private List<String> inputList;
    private List<String> outputList;
    private Question question;
    private List<JudgeCase> judgeCaseList;
    private QuestionSubmit questionSubmit;
}
