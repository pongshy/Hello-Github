package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NameInfo {
    @NotBlank(message = "姓名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
