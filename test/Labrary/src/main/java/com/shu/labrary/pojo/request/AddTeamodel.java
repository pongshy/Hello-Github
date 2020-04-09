package com.shu.labrary.pojo.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddTeamodel {
    @NotBlank(message = "教师Id不能为空")
    @Size(min = 8,max = 11)
    private String teacherID;

    @Size(min = 2,max = 20)
    @NotBlank(message = "教师姓名不能为空")
    private String teachername;

    @NotBlank(message = "部门Id不能为空")
    private String department1id;

    private String campus;

    private String building;

    private String housenumber;

    private Boolean free;

    private Boolean online;

    private String teachstarttime;

    private String teachendtime;

    private String major;

    private String helpintention;

    private String job;

    private String description;

    private String imgurl;

    private String phone;

    private String email;


}
