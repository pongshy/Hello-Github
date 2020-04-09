package com.shu.labrary.pojo.response;

import lombok.Data;

import java.util.Date;

/**
 * program: BrokenPersonInformationVO
 * description: 管理员页面显示学生信息
 * author: pongshy
 * create: 2020-1-1
 */
@Data
public class BrokenPersonInformationVO {
    private Integer userid;

    private String name;

    private String reason;

    private String time;


}
