package com.shu.labrary.pojo.request;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ManagerAddVo {
    @NotBlank(message = "教师姓名不能为空")
    @Size(max = 11,min = 8)
    private String teacherID;

    @NotBlank(message = "教师姓名不能为空")
    @Size(min = 1,max = 9)
    private String teachername;

    @NotBlank(message = "手机号不能为空")
    @Size(min = 6,max =11 )
    private String phone;

    @NotBlank(message = "部门不能为空")
    private String depId;
}
