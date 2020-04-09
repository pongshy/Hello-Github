package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * program: ConfirmPaperUpload
 * description: 接受用户上传的学生信息，论文地址及教师Id
 * author: pongshy
 * create: 2020-1-31
 */
@Data
public class ConfirmPaperUploadInfo {
    @NotNull(message = "教师id不能为空")
    private Integer teacherid;

    @NotNull(message = "学生id不能为空")
    private Integer studentId;

    @NotBlank(message = "论文存储地址不能为空")
    private String essaysrc;

    @NotBlank(message = "介绍不能为空")
    private String description;

    @NotBlank(message = "论文名称不能为空")
    private String essayname;

    @NotNull(message = "预约时间的id不能为空")
    private Integer timeid;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getEssaysrc() {
        return essaysrc;
    }

    public void setEssaysrc(String essaysrc) {
        this.essaysrc = essaysrc;
    }

    public String getEssayname() {
        return essayname;
    }

    public void setEssayname(String essayname) {
        this.essayname = essayname;
    }

    public Integer getTimeid() {
        return timeid;
    }

    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }
}
