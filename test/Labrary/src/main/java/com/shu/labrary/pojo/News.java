package com.shu.labrary.pojo;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class News {
    private Integer newsid;
    @NotBlank(message = "文章名字不能为空")
    private String newsname;
    @NotBlank(message = "类型不能为空")
    private String newstype;
    @NotBlank(message = "状态不能为空")
    private String newsstatus;
    @NotBlank(message = "权限不能为空")
    private String newsauth;
    @NotNull
    private Date newstime;

    private String newslabel;

    private Integer havepicture;

    private String newscontext;


}