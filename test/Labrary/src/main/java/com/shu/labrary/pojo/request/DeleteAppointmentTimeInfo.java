package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description: 教师删除预约时间
 * @Param: [DeleteAppointmentTimeInfo]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-5
 */
@Data
public class DeleteAppointmentTimeInfo {
    @NotNull(message = "id不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
