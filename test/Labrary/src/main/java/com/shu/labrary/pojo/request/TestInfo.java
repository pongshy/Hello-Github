package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TestInfo {
    @NotBlank(message = "名字不能为空")
    @Size(min = 1, max = 5, message = "长度是1~5")
    private String name;

    @NotNull(message = "id不能为空")
    private Integer id;
}
