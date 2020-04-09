package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * program: AddBrokenPersonInfo
 * description: 增加失信人员
 * author: pongshy
 * create: 2020-1-1
 */
@Data
public class AddBrokenPersonInfo {
    @NotNull(message = "用户Id不能为空")
    private Integer userId;

    @NotBlank(message = "用户姓名不能为空")
    private String name;

    @NotNull(message = "原因不能为空")
    private String description;


}
