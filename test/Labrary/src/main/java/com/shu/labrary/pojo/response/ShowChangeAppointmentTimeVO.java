package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowChangeAppointmnetTimeVO
 * description: 管理员页面显示学生信息
 * author: pongshy
 * create: 2020-2-5
 */
@Data
public class ShowChangeAppointmentTimeVO {
    private Integer id;

    private String startTime;

    private String endTime;


}
