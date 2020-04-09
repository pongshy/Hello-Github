package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * program: DeleteBrokenPersonInfo
 * description: 删除一些失信人员
 * author: pongshy
 * create: 2020-1-1
 */
@Data
public class DeleteBrokenPersonInfo {
    @NotNull(message = "不能为空")
    private Integer userId;
}
