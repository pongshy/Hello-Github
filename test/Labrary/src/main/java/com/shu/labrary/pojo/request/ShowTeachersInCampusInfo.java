package com.shu.labrary.pojo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 用户选择校区，同时给出页码，显示默认为所有学院的老师
 * @Param: []
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-19
 */
public class ShowTeachersInCampusInfo {
    @NotBlank(message = "校区不能为空")
    private String campus;

    @NotNull(message = "页数不能为空")
    private Integer page;

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
