package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description: 修改小老师个人信息
 * @Param: [ChangeStTeacherInformation]
 * @Return: com.shu.labrary.model.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-3-9
 */
@Data
public class ChangeStTeacherInformationInfo {
    @NotNull(message = "小老师Id不能为空")
    private Integer stteacherid;

    private String helpintention;

    private String building;

    private String description;

    private String organization;

    private String campus;

    private String email;

    private String phone;
}
