package com.da.oj.judge;

import com.da.oj.judge.strategy.DefaultJudgeStrategy;
import com.da.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.da.oj.judge.strategy.JudgeContext;
import com.da.oj.judge.strategy.JudgeStrategy;
import com.da.oj.model.dto.questionSubmit.JudgeInfo;
import com.da.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理，简化调用
 */
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
