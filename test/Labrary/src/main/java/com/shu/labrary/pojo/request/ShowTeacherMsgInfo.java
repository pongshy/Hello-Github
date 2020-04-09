package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * program: ShowTeacherMsgInfo
 * description: 后端接受前端发来的校区和学院
 * author: pongshy
 * create: 2020-1-1
 */
@Data
public class ShowTeacherMsgInfo {
    @NotBlank(message = "校区不能为空")
    private String campsuList;

    @NotBlank(message = "学院名不能为空")
    private String academy;

    @NotNull(message = "页数不能为空")
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getCampsuList() {
        return campsuList;
    }

    public void setCampsuList(String campsuList) {
        this.campsuList = campsuList;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
