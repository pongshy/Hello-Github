package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class FamousTeacherInfo {
    @NotNull
    @Size(max = 10,min = 2)
    private String teacherName;
    @NotNull
    private String html;
}
