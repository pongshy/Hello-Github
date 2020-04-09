package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 问卷加载
 * @Param: [StudentQuestionInfo]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-7
 */
@Data
public class StudentQuestionInfo {
    @NotNull(message = "预约订单号不能为空")
    private Integer requestId;

    @NotBlank(message = "身份识别不能为空")
    private String duty;                    //duty = 教职工，学生教师， 本科生，硕士生，博士生

    @NotNull(message = "identity不能为空")
    private Integer identity;               //identity -> 0 表明是被辅导，identity -> 1 表明该用户是辅导别人

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

}
