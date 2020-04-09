package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: StudentInformationVO
 * description: 管理员页面显示学生信息
 * author: pongshy
 * create: 2020-1-1
 */
@Data
public class StudentInformationVO {
    private Integer adminid;

    private String name;

    private String duty;

    private Boolean online;

    private String phone;

    private String organization;

    private Integer brokenrecord;

    private Integer eassyid;
}
