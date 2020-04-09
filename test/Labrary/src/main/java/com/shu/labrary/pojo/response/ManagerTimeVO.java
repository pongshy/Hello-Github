package com.shu.labrary.pojo.response;
import lombok.Data;

/**
 * program: TeacherTimeVO
 * description: 专门用于存储教师设置的预约时间，拆分版
 * author: pongshy
 * create: 2020-2-3
 */
@Data
public class ManagerTimeVO {
    private Integer teacherid;

    private String starttime;

    private String endtime;

    private Integer occupy;

}
