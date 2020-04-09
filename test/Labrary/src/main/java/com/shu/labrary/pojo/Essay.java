package com.shu.labrary.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Essay {
    private Integer essayid;

    private String essayname;

    private String description;

    private String essaysrc;

    private Integer onlin;

    private Integer teacherid;

    private Date finishtime;

    private Integer adminid;


}