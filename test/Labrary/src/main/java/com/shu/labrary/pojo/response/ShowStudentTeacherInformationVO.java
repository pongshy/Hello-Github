package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowStudentTeacherInformation
 * description: 显示小老师的个人信息
 * author: pongshy
 * create: 2020-3-9
 */
@Data
public class ShowStudentTeacherInformationVO {
    private Integer stteacherid;

    private String stteachername;

    private String duty;

    private String academy;

    private String helpintention;

    private String building;

    private String imagesrc;

    private String description;

    private String organization;

    private String campus;

    private String satisfaction;

    private String email;

    private String phone;

    private Integer online;
}
