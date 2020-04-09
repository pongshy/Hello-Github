package com.shu.labrary.pojo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 教师修改个人头像
 * @Param: [ModifyImageInfo]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-22
 */
public class ModifyImageInfo {
    @NotBlank(message = "不能为空")
    private String src;

    @NotNull(message = "教师Id不能为空")
    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
