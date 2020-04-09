package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: TeacherSeeAppointmentVO
 * description: 教师查看预约情况
 * author: pongshy
 * create: 2020-2-2
 */
@Data
public class TeacherSeeAppointmentVO {
    private String studentName;

    private String studentId;

    private String academy;

    private String essaysrc;

    private String essayName;

    private String startTime;

    private String endTime;

    private Integer online;

    private String phoneNumber;

    private Integer requestId;

    private Integer applyStatus;

    private String email;
}
