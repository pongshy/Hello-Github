package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class StTeacherInfo {
    @NotNull
    private  Integer stteacherid;

    @NotNull
    private  String  stteachername;
    @NotNull
    private  String duty;
    @NotNull
    private  Integer departmentid;
    private  String helpintention;
    private  String description;

}
