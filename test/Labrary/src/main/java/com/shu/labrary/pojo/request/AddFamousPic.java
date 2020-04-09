package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddFamousPic {
    @NotNull
    @Size(min = 1,max = 1)
    private String picNum;
    @NotNull
    private String newsName;
    @NotNull
    private String picsrc;
}
