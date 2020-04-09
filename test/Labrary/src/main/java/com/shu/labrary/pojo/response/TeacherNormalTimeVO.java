package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: TeacherNormalTimeVO
 * description: 专门用于存储教师设置的预约时间，完整版
 * author: pongshy
 * create: 2020-2-3
 */
@Data
public class TeacherNormalTimeVO {
    private Integer id;

    private Integer occupy;

    private String startTime;

    private String endTime;



}
