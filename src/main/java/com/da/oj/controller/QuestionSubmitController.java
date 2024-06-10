package com.da.oj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.da.oj.common.BaseResponse;
import com.da.oj.common.ErrorCode;
import com.da.oj.common.ResultUtils;
import com.da.oj.exception.BusinessException;
import com.da.oj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.da.oj.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.da.oj.model.entity.QuestionSubmit;
import com.da.oj.model.entity.User;
import com.da.oj.model.vo.QuestionSubmitVO;
import com.da.oj.service.QuestionSubmitService;
import com.da.oj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/DaDaTzz">程序员Da</a>
 * @from <a href="https://github.com/DaDaTzz">程序员Da</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                         HttpServletRequest request) {
        if(questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        Long id = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(id);
    }



    /**
     * 分页获取题目提交列表，除了管理员外，普通用户只能看到非答案，提交代码等公开信息
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 查询数据库
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        // 数据脱敏
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, request));
    }


}
