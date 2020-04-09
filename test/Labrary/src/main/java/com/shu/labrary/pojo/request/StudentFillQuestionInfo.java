package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 学生填写问卷
 * @Param: [StudentFillQuestionInfo]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-7
 */
@Data
public class StudentFillQuestionInfo {
    @NotNull(message = "是否准时不能为空")
    private Integer onTime;

    @NotNull(message = "学生对老师的评分不能为空")
    private double teacherMark;

    @NotNull(message = "对辅导内容的评分不能为空")
    private Integer msgMark;

    private String advice;

    @NotNull(message = "问卷Id不能为空")
    private Integer id;

    @NotNull(message = "订单号不能为空")
    private Integer requestId;


    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    public double getTeacherMark() {
        return teacherMark;
    }

    public void setTeacherMark(double teacherMark) {
        this.teacherMark = teacherMark;
    }

    public Integer getMsgMark() {
        return msgMark;
    }

    public void setMsgMark(Integer msgMark) {
        this.msgMark = msgMark;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
