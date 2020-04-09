package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteAppointment {
    @NotNull(message = "申请人的Id不能为空")
    private Integer amdinId;

    @NotNull(message = "被申请教师的Id不能为空")
    private Integer teacherId;

    public Integer getAmdinId() {
        return amdinId;
    }

    public void setAmdinId(Integer amdinId) {
        this.amdinId = amdinId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
