package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 教师填写问卷
 * @Param: [TeacherFillQuestion]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-7
 */
@Data
public class TeacherFillQuestionInfo {
    @NotNull(message = "学生是否缺席不能为空")
    private Integer absent;         //1代表缺席，0代表没有缺席

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "对学生的评价不能为空")
    private double studentMark;

    private String advice;

    @NotNull(message = "订单号不能为空")
    private Integer requestId;

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(double studentMark) {
        this.studentMark = studentMark;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
