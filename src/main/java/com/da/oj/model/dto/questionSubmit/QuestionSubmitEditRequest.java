package com.da.oj.model.dto.questionSubmit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 编辑题目提交请求
 *
 * @author <a href="https://github.com/DaDaTzz">程序员Da</a>
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
@Data
public class QuestionSubmitEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;


    /**
     * 判题信息 （json 数组）
     */
    private String judgeInfo;

    private static final long serialVersionUID = 1L;
}