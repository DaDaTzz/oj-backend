package com.da.oj.model.dto.questionSubmit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.da.oj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询题目提交请求
 *
 * @author <a href="https://github.com/DaDaTzz">程序员Da</a>
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    private String searchText;

    /**
     * id
     */
    private Long id;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 判题状态 0-待判题 1-判题中 2-成功 3-失败
     */
    private Integer status;

    /**
     * 判题信息 （json 数组）
     */
    private JudgeInfo judgeInfo;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}