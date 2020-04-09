package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowStudentVO
 * description: 学生页面显示学生个人信息
 * author: pongshy
 * create: 2020-1-31
 */
@Data
public class ShowStudentVO {
    private String name;

    private String studentId;

    private String academy;

    private String telephone;

    private String email;

}
